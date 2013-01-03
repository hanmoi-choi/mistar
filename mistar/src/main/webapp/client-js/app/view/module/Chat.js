/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 31/12/12
 *
 *
 */
Ext.define('MIStar.view.module.Chat', {
    extend: 'Ext.window.Window',
    alias: 'widget.chat-view',
    require: ['ChatMessages'],
    id: 'view.module.Chat',
    title: 'Chat',

    width: 600,
    height: 400,
    iconCls: 'notepad',
    animCollapse: false,
    border: false,
    //defaultFocus: 'notepad-editor', EXTJSIV-1300

    // IE has a bug where it will keep the iframe's background visible when the window
    // is set to visibility:hidden. Hiding the window via position offsets instead gets
    // around this bug.
    hideMode: 'offsets',
    layout: 'fit',


    initComponent: function () {
        var me = this;
        me.items = [me.createChatGridPanel()];
        me.callParent(arguments);
    },

    createChatGridPanel: function(){
        return {
            xtype: 'grid',
            border: false,
            store: 'ChatMessages',
//        store: Ext.create('Ext.data.ArrayStore', {}),
//        columns: createColumns(4),
            columns: [
                {
                    dataIndex: 'fromWhom',
                    text: 'From',
                    filterable: false,
                    flex: 0.1
                },
                {
                    dataIndex: 'createAt',
                    text: 'Date',
                    filterable: false,

                    flex: 0.2,
                    renderer: this.dateRenderer
                },
                {
                    dataIndex: 'message',
                    text: 'Message',
                    filterable: false,
                    flex: 0.7
                }
            ],

            dockedItems: [Ext.create('Ext.toolbar.Toolbar', {
                dock: 'bottom',
                width   : 600,
                items: [
                    {
                        xtype    : 'textfield',
                        name     : 'chat-message-text',
                        fieldLabel: 'Message',
                        emptyText: 'Enter Message To Send',
                        flex: 0.8
                    },
                    {
                        xtype: 'button',
                        text: 'Send',
                        action: 'send',
                        flex: 0.1
                    }
                ]
            })],
            loadMask: true
        };
    },

    dateRenderer: function(value, id, r) {
        var yourDate = r.data['createdAt'];
        return Ext.Date.format(yourDate, 'Y-m-d H:i:s');
    }
});
