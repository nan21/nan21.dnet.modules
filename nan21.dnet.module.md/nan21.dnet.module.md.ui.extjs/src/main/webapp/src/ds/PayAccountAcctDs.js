/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.org.ds.model.PayAccountAcctDs" ,{
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
		{name:"payAccountId", type:"int", useNull:true},
		{name:"payAccount", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"depositAccountId", type:"int", useNull:true},
		{name:"depositAccount", type:"string"},
		{name:"withdrawalAccountId", type:"int", useNull:true},
		{name:"withdrawalAccount", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.org.ds.model.PayAccountAcctDsFilter" ,{
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
		{name:"payAccountId", type:"int", useNull:true},
		{name:"payAccountId_From",type:"int", useNull:true},
		{name:"payAccountId_To",type:"int", useNull:true},
		{name:"payAccount", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"depositAccountId", type:"int", useNull:true},
		{name:"depositAccountId_From",type:"int", useNull:true},
		{name:"depositAccountId_To",type:"int", useNull:true},
		{name:"depositAccount", type:"string"},
		{name:"withdrawalAccountId", type:"int", useNull:true},
		{name:"withdrawalAccountId_From",type:"int", useNull:true},
		{name:"withdrawalAccountId_To",type:"int", useNull:true},
		{name:"withdrawalAccount", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.org.ds.param.PayAccountAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 