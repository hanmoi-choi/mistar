
Ext.define('MIStar.controller.module.Notepad', {
    extend: 'Ext.app.Controller',
    id:'module.Notepad',

    views: ['MIStar.view.module.Notepad'],

    init : function(){
        var me = this;
        me.viewId = 'view.'+me.id;

        me.callParent(arguments);
    },

    createWindow : function(){
        var me = this;
        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(me.viewId);

        if(!win){
            var view = Ext.create('MIStar.view.module.Notepad');
            win = desktop.createWindow(view);
        }

        win.show();
        return win;
    }
});

