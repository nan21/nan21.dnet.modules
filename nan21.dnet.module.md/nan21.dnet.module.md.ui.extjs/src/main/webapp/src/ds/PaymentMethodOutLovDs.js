/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.PaymentMethodOutLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"type", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.PaymentMethodOutLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"type", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.base.tx.ds.param.PaymentMethodOutLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 