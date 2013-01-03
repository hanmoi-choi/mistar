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

Ext.define('MIStar.view.module.Notepad',{
    extend: 'Ext.window.Window',

    requires: [
        'Ext.form.field.HtmlEditor'
        //'Ext.form.field.TextArea'
    ],

    id: 'view.module.NotePad',
    title:'Notepad',

    width:600,
    height:400,
    iconCls: 'notepad',
    animCollapse:false,
    border: false,
    floatable: true,
    //defaultFocus: 'notepad-editor', EXTJSIV-1300

    // IE has a bug where it will keep the iframe's background visible when the window
    // is set to visibility:hidden. Hiding the window via position offsets instead gets
    // around this bug.
    hideMode: 'offsets',

    layout: 'fit',

    initComponent : function(){
        var me = this;

        me.items = [
            {
                xtype: 'htmleditor',
                //xtype: 'textarea',
                id: 'notepad-editor',
                value: [
                    'Some <b>rich</b> <font color="red">text</font> goes <u>here</u><br>',
                    'Give it a try!'
                ].join('')
            }
        ];



        me.callParent(arguments);
    }

})
