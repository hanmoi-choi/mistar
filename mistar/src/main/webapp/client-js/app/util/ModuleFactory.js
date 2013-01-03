/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 3/01/13
 *
 *
 */

Ext.define('MIStar.util.ModuleFactory',{
    singleton: true,
    moduleControllers: null,

    getModuleControllers: function(app){
        var me = this, application = app, modules = [];

        if(me.moduleControllers === null){
            me.moduleControllers = Ext.create('MIStar.store.system.ModuleInfos');
        }

        me.moduleControllers.each(function(record){
            var id = record.data['id'];
            var module = application.getController(id);
            modules.push(module);
        });

        return modules;
    },

    getShortcuts: function(){
        var me = this;

        if(me.moduleControllers === null){
            me.moduleControllers = Ext.create('MIStar.store.system.ModuleInfos');
        }

        return me.moduleControllers;
    }

});
