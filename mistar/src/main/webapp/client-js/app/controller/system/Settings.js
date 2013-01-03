
Ext.define('MIStar.controller.system.Settings', {
    extend: 'Ext.app.Controller',

    views:['MIStar.view.system.Settings'],

//    refs:[
//        {
//            ref: 'settingsView',
//            selector: 'settingsView'
//        }
//    ],

    constructor: function(){
        var me = this;

        me.view = Ext.create('MIStar.view.system.Settings');
        me.view.show();
        console.log('controller')

//        this.callParanet();

        me.control({
            'settingsView button':{
                click:this.onButtonClick
            }
        });
//
//        me.application.on({
//
//        });
    },

    onButtonClick: function(btn, e){

        var me = this;

        console.log(btn);
        console.log(e);
//
//        if (me.selected) {
//            me.desktop.setWallpaper(me.selected, me.stretch);
//        }
//        me.destroy();
    }
});

