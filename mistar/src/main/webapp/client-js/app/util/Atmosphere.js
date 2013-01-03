/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 31/12/12
 *
 *
 */

Ext.define('MIStar.util.Atmosphere',{
    extend: 'Ext.util.Observable',


    requires:['MIStar.util.GlobalVar'],
    //private
    sendingSocket: null,

    constructor: function(config){
        var me = this;
//        Ext.apply(me, config);
        MIStar.util.GlobalVar.atmosphereWrapper = me;

        me.addEvents('atmosphere');

        me.callParent(arguments);

        var socket = $.atmosphere;

        var request = config || {
            url: 'http://localhost:8080/mi/async',
            contentType : "application/json",
            logLevel : 'debug',
            transport : 'websocket' ,
            fallbackTransport: 'long-polling'};

        request.onOpen = me.onOpen;
        request.onReconnect = me.onReconnect;
        request.onMessage = me.onMessage;
        request.onError = me.onError;


        me.sendingSocket = socket.subscribe(request);


    },

    sendMessage: function(message){
        var me = this;
        if(typeof message === "string")
            me.sendingSocket.push(message);
        else
            me.sendingSocket.push(Ext.JSON.encode(message));

    },

    onOpen: function(response) {

    },

    onReconnect: function(request, response) {

    },

    onMessage:  function (response) {
        var wrapper = MIStar.util.GlobalVar.atmosphereWrapper;


        var message = response.responseBody;
        var record = Ext.JSON.decode(message);
        try {

            wrapper.fireEvent('atmosphere', record);
            console.log(message);

        } catch (e) {
            console.log('e: ', e);
            console.log('Error: ', message);
            return;
        }

    },

    onError: function(response) {

    }

});
