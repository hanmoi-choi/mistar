/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 19/12/12
 *
 *
 */

Ext.application({
    name: 'MIStar',
    appFolder: 'client-js/app',

    controllers:[
        'system.Desktop',
        'module.Notepad',
        'module.UserAdmin',
        'module.Chat'
    ],

    views:['system.Desktop'],

    launch: function(){

    }
});

