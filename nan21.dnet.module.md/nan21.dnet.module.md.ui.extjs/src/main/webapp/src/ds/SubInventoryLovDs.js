/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.org.ds.model.SubInventoryLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"inventoryId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.org.ds.model.SubInventoryLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"inventoryId", type:"int", useNull:true},
		{name:"inventoryId_From",type:"int", useNull:true},
		{name:"inventoryId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.org.ds.param.SubInventoryLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 