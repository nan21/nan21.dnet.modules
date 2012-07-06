/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docType", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"description", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docTypeId_From",type:"int", useNull:true},
		{name:"docTypeId_To",type:"int", useNull:true},
		{name:"docType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.param.InvTransactionTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 