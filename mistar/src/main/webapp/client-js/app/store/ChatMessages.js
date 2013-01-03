/**
 * Chat Store
 *
 * @class App.Store.Chat
 * @namespace App.Store
 * @extends Ext.data.Store
 * @author Nils Dehl <mail@nils-dehl.de>
 */
Ext.define('MIStar.store.ChatMessages',{
    extend: 'Ext.data.Store',

    model:'MIStar.model.ChatMessage'
});
