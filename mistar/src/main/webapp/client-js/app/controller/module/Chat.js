/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 31/12/12
 *
 *
 */

Ext.define('MIStar.controller.module.Chat',{
    extend: 'Ext.app.Controller',
    id:'module.Chat',

    require: ['Ext.Date.format', 'Ext.Date.patterns'],
    views: ['module.Chat'],
    models: ['ChatMessage'],
    stores: ['ChatMessages'],

    init : function(){
        var me = this;

        me.viewId = 'view.'+me.id;
        me.callParent(arguments);

        me.control({
            'chat-view button[action=send]' : {
                click: me.onSendMessage
            }
        });

        me.on('destroy', me.onDestroy);
    },

    createWindow : function(){
        var me = this;

        var desktop = this.app.getDesktop();
        var win = desktop.getWindow(me.viewId);

        if(!win){
            var view = Ext.create('MIStar.view.module.Chat');
            win = desktop.createWindow(view);

            me.createSocket();
        }

        win.show();
        return win;
    },

    createSocket: function(){
        var me = this;

        if(!me.socket){
            me.socket = Ext.create('MIStar.util.Atmosphere');
            me.socket.addListener('atmosphere', this.onSocket);
            me.socket.controller = me;
        }
    },

    onSocket: function(data){
        this.controller.getChatMessagesStore().add(data);
    },

    onSendMessage: function(button) {
        var me = this,
            toolbar = button.up('toolbar'),
            textfield = toolbar.down('textfield');

        var date = Ext.Date.format(new Date(Ext.Date.now()), 'Y-m-d H:i:s');

        var record = {
            'fromWhom': 'hanmoi',
            'createdAt': date,
            'message': textfield.getValue()
        };

        me.socket.sendMessage(record);

    },

    onDestroy: function(){
        console.log('here');
    }
});
