/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 24/12/12
 *
 *
 */
Ext.define('MIStar.store.Users',{
    extend: 'Ext.data.Store',

    model:'MIStar.model.User',

    proxy: {
        type: 'ajax',
        url:'http://localhost:8080/mi/user/add',

        api: {
            update: 'http://localhost:8080/mi/user/add'
        },
        reader: {
            type: 'json',
            root: 'data',
            successProperty: 'success'
        },
        writer: {
            type: 'json',
            writeAllFields: true,
            encode: false,
            root: 'data'
        },
        listeners: {
            exception: function(proxy, response, operation){
                Ext.MessageBox.show({
                    title: 'REMOTE EXCEPTION',
                    msg: operation.getError(),
                    icon: Ext.MessageBox.ERROR,
                    buttons: Ext.Msg.OK
                });
            }
        }
    },
    autoSync: true
});

