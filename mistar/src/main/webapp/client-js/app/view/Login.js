/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 19/12/12
 *
 *
 */

Ext.define('MIStar.view.Login', {
    extend: 'Ext.panel.Panel',

    alias: 'mistar-login-view',

    title: 'Log In',
    layout: 'fit',
    autoShow: true,

    items: [
        {
            xtype: 'textfield',
            name: 'name',
            fieldLabel: 'Name'
        },
        {
            xtype: 'textfield',
            name: 'password',
            fieldLabel: 'Password',
            inputType: 'password'
        }
    ]

});
