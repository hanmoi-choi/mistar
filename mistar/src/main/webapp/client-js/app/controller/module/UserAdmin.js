
Ext.define('MIStar.controller.module.UserAdmin', {
    extend: 'Ext.app.Controller',
    id:'module.UserAdmin',

    views: ['module.UserAdmin'],
    models: ['User'],
    stores: ['Users'],

    //self defined property
    viewId: null,

    init : function(){
        var me = this;
        me.viewId = 'view.'+me.id;
        me.callParent(arguments);

        me.control({
            'useradmin-view button[action=add]' : {
                click: me.onAddUser
            }
        })

    },

    createWindow : function(){
        var me = this,
            desktop = me.app.getDesktop(),
            win = desktop.getWindow(me. viewId);

        if(!win){
            var view = Ext.create('MIStar.view.module.UserAdmin');
            win = desktop.createWindow(view);
        }

        win.show();
        return win;
    },

    onAddUser: function(button) {
        var me = this,
            win = button.up('window'),
            form = win.down('form'),
            record,
            values = form.getValues();

        record = Ext.create('MIStar.model.User');
        record.set(values);
        record.setId(0);

        me.getUsersStore().add(record);
        win.close();
        me.getUsersStore().sync();


    }
});

