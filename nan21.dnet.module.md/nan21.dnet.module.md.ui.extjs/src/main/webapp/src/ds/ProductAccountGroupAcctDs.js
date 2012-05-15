/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountGroupAcctDs" ,{
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
		{name:"groupId", type:"int", useNull:true},
		{name:"group", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"expenseAccountId", type:"int", useNull:true},
		{name:"expenseAccount", type:"string"},
		{name:"revenueAccountId", type:"int", useNull:true},
		{name:"revenueAccount", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountGroupAcctDsFilter" ,{
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
		{name:"groupId", type:"int", useNull:true},
		{name:"groupId_From",type:"int", useNull:true},
		{name:"groupId_To",type:"int", useNull:true},
		{name:"group", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"expenseAccountId", type:"int", useNull:true},
		{name:"expenseAccountId_From",type:"int", useNull:true},
		{name:"expenseAccountId_To",type:"int", useNull:true},
		{name:"expenseAccount", type:"string"},
		{name:"revenueAccountId", type:"int", useNull:true},
		{name:"revenueAccountId_From",type:"int", useNull:true},
		{name:"revenueAccountId_To",type:"int", useNull:true},
		{name:"revenueAccount", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductAccountGroupAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 