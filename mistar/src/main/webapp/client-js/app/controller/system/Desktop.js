/*
 * This source code is from sencha.com
 * In the favor of MVC pattern and easiness of add module, the original source code has been modified.
 *
 * @Author  : Hanmoi Daniel Choi.
 *
 */

Ext.define('MIStar.controller.system.Desktop', {
    extend: 'Ext.app.Controller',

    requires: [
        'Ext.container.Viewport',
        'MIStar.Constant',
        'MIStar.util.ModuleFactory'
    ],

    views:['system.Desktop'],
    models:['system.Shortcut'],


    //self defined property.
    isReady: false,
    modules: null,
    desktop: null,
//    viewport: null,

    useQuickTips: true,

    init: function() {
        var me = this, desktopCfg;

        if (me.useQuickTips) {
            Ext.QuickTips.init();
        }

        me.modules = me.getModules();
        if (me.modules) {
            me.initModules(me.modules);
        }
        desktopCfg = me.getDesktopConfig();
        me.desktop = new MIStar.view.system.Desktop(desktopCfg);

        me.viewport = Ext.create('Ext.container.Viewport', {
                layout: 'fit',
                items: [ me.desktop ]
            }
        );

        me.addEvents(
            'ready',
            'beforeunload'
        );

        Ext.EventManager.on(window, 'beforeunload', me.onUnload, me);
        Ext.EventManager.on(window, 'ready', me.onReady, me);
        me.isReady = true;
        me.fireEvent('ready', me);

        //init data
        Ext.Ajax.request({
            url: MIStar.Constant.SERVER_URL+'/init',
            method: 'POST',
            success: function(response){
                var returnMsg = response.responseText;

                var userConfig = Ext.decode(returnMsg);
                var wallpaperImage = userConfig['wallPaperImage'];
                var isStreched = userConfig['isStreched'];

                console.log(wallpaperImage);
                console.log(isStreched);

                console.log(me);
                me.desktop.setWallpaper(wallpaperImage, isStreched);
            }
        });
    },

    getModules : function(){
        return MIStar.util.ModuleFactory.getModuleControllers(this.application);
    },

    /**
     * This method returns the configuration object for the Desktop object. A derived
     * class can override this method, call the base version to build the config and
     * then modify the returned object before returning it.
     */
    getDesktopConfig: function () {
        var me = this, cfg = {
            app: me,
            taskbarConfig: me.getTaskbarConfig()
        };

        Ext.apply(cfg, me.desktopConfig);

        Ext.apply(cfg, {
//            cls: 'ux-desktop-black',

            contextMenuItems: [
                { text: 'Change Settings', handler: me.onSettings, scope: me }
            ],

            shortcuts: MIStar.util.ModuleFactory.getShortcuts(),

            wallpaper: MIStar.Constant.WALLPAPER_IMAGE_PATH + 'Blue-Sencha.jpg',
            wallpaperStretch: false
        });
        return cfg;
    },



    /**
     * This method returns the configuration object for the TaskBar. A derived class
     * can override this method, call the base version to build the config and then
     * modify the returned object before returning it.
     */
    getTaskbarConfig: function () {
        var me = this, cfg = {
            app: me,
            startConfig: me.getStartConfig()
        };

        Ext.apply(cfg, me.taskbarConfig);

        Ext.apply(cfg, {
            quickStart: [
//                { name: 'Accordion Window', iconCls: 'accordion', module: 'acc-win' },
//                { name: 'Grid Window', iconCls: 'icon-grid', module: 'grid-win' }
            ],
            trayItems: [
                { xtype: 'trayclock', flex: 1 }
            ]
        });

        return cfg;
    },

    /**
     * This method returns the configuration object for the Start Button. A derived
     * class can override this method, call the base version to build the config and
     * then modify the returned object before returning it.
     */
    getStartConfig: function () {
        var me = this, cfg = {
            app: me,
            menu: []
        };

        Ext.apply(cfg, me.startConfig);

        Ext.each(me.modules, function (module) {
            if (module.launcher) {
                cfg.menu.push(module.launcher);
            }
        });

        Ext.apply(cfg, {
            title: 'Web MIStar',
            iconCls: 'user',
            height: 300,
            toolConfig: {
                width: 100,
                items: [
                    {
                        text:'Settings',
                        iconCls:'settings',
                        handler: me.onSettings,
                        scope: me
                    },
                    '-',
                    {
                        text:'Logout',
                        iconCls:'logout',
                        handler: me.onLogout,
                        scope: me
                    }
                ]
            }
        });

        return cfg;
    },

    initModules : function(modules) {
        var me = this;
        Ext.each(modules, function (module) {
            module.app = me;
        });
    },

    getModule : function(name) {
        var ms = this.modules;
        for (var i = 0, len = ms.length; i < len; i++) {
            var m = ms[i];

            if (m.id === name || m.appType === name) {
                return m;
            }
        }
        return null;
    },

    getDesktop : function() {
        return this.desktop;
    },

    onReady : function(fn, scope) {
        var me = this;

        if (this.isReady) {
            fn.call(scope, me);
        } else {
            this.on({
                ready: fn,
                scope: scope,
                single: true
            });
        }
    },

    onUnload : function(e) {
        if (this.fireEvent('beforeunload', this) === false) {
            e.stopEvent();
        }
    },

    onSettings: function(){
        Ext.create('MIStar.view.system.Settings',{
            desktop:this.desktop}
        ).show();
    }
});

