/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.bd.acc.ds.model.AccItemAcctDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"accItemId", type:"int", useNull:true},
		{name:"accItem", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"crAccountId", type:"int", useNull:true},
		{name:"crAccount", type:"string"},
		{name:"dbAccountId", type:"int", useNull:true},
		{name:"dbAccount", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.acc.ds.model.AccItemAcctDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"accItemId", type:"int", useNull:true},
		{name:"accItemId_From",type:"int", useNull:true},
		{name:"accItemId_To",type:"int", useNull:true},
		{name:"accItem", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"crAccountId", type:"int", useNull:true},
		{name:"crAccountId_From",type:"int", useNull:true},
		{name:"crAccountId_To",type:"int", useNull:true},
		{name:"crAccount", type:"string"},
		{name:"dbAccountId", type:"int", useNull:true},
		{name:"dbAccountId_From",type:"int", useNull:true},
		{name:"dbAccountId_To",type:"int", useNull:true},
		{name:"dbAccount", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.acc.ds.param.AccItemAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 