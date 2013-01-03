/**
 * Chat Message Model
 *
 * @author Nils Dehl <mail@nils-dehl.de>
 */
Ext.define('MIStar.model.ChatMessage',{
    extend: 'Ext.data.Model',
    fields: [
        { name: 'fromWhom', type: 'string' },
        { name: 'createdAt', dateFormat: 'Y-m-d H:i:s', type: 'date'},
        { name: 'message', type: 'string'}
    ]
//    proxy: {
//        type: 'rest',
//        url:'../comments',
//        writer:{
//            type:'json'
//        },
//        reader: {
//            type: 'json',
//            getData:function(data){
//                for(i = 0; i < data.length; i++){
//                    data[i].createdAt = Ext.Date.format(new Date(data[i].createdAt), "Y-m-Y-m-d H:i:s");
//                }
//                return data;
//            }
//        }
//    }


});
