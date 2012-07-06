/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.DeliveryMethodLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"delivery", type:"boolean"},
		{name:"externalCourier", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.md.base.tx.ds.model.DeliveryMethodLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"delivery", type:"boolean", useNull:true},
		{name:"externalCourier", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.base.tx.ds.param.DeliveryMethodLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 