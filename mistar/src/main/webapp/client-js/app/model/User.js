/**
 *
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date  : 24/12/12
 *
 *
 */

Ext.define('MIStar.model.User',{
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', type: 'string' },
        { name: 'name', type: 'string'},
        { name: 'password', type: 'string'}
    ]
});
