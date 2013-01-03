/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 3/01/13
 *
 *
 */

Ext.define('MIStar.store.system.ModuleInfos',{
    extend: 'Ext.data.Store',
    model: 'MIStar.model.system.ModuleInfo',

    data: [
        { id: 'module.Notepad', name: 'Notepad', iconCls: 'notepad-shortcut'},
        { id: 'module.UserAdmin', name: 'UserAdmin', iconCls: 'notepad-shortcut'},
        { id: 'module.Chat', name: 'Chat', iconCls: 'notepad-shortcut'}
    ]
});
