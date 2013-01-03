/*

 This file is part of Ext JS 4

 Copyright (c) 2011 Sencha Inc

 Contact:  http://www.sencha.com/contact

 GNU General Public License Usage
 This file may be used under the terms of the GNU General Public License version 3.0 as published by the Free Software Foundation and appearing in the file LICENSE included in the packaging of this file.  Please review the following information to ensure the GNU General Public License version 3.0 requirements will be met: http://www.gnu.org/copyleft/gpl.html.

 If you are unsure which license is appropriate for your use, please contact the sales department at http://www.sencha.com/contact.

 */
/*!
 * Ext JS Library 4.0
 * Copyright(c) 2006-2011 Sencha Inc.
 * licensing@sencha.com
 * http://www.sencha.com/license
 */

Ext.define('MIStar.view.module.UserAdmin',{
    extend: 'Ext.window.Window',
    alias: 'widget.useradmin-view',

    requires: [
        'Ext.form.field.Text'
    ],

    id: 'view.module.UserAdmin',
    title:'UserAdmin',

//    width:600,
//    height:200,
    iconCls: 'notepad',
    animCollapse:false,
    border: false,
    //defaultFocus: 'notepad-editor', EXTJSIV-1300

    // IE has a bug where it will keep the iframe's background visible when the window
    // is set to visibility:hidden. Hiding the window via position offsets instead gets
    // around this bug.
    hideMode: 'offsets',

    layout: 'fit',
    bodyPadding: 10,

    initComponent : function(){
        var me = this;

        me.items = [
            {
                xtype: 'form',

                items:[

                    {
                        xtype: 'textfield',
                        name: 'id',
                        fieldLabel: 'User Id',
                        allowBlank: false
                    },

                    {
                        xtype: 'textfield',
                        name: 'name',
                        fieldLabel: 'UserName',
                        allowBlank: false
                    },

                    {
                        xtype: 'textfield',
                        name: 'password',
                        fieldLabel: 'Password',
                        inputType: 'password',
                        allowBlank: false
                    }
                ]
            }
        ];

        me.buttons = [
            {
                text: 'Add',
                action: 'add'
            },

            {
                text: 'Cancel',
                scope: this,
                handler: this.onClose
            }
        ];

        me.callParent(arguments);
    },

    onClose: function(){
        var me = this;

        me.close();

    }
});
