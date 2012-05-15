/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.CustomerGroupAcctDs" ,{
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
		{name:"custGroupId", type:"int", useNull:true},
		{name:"custGroup", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"salesAccountId", type:"int", useNull:true},
		{name:"salesAccount", type:"string"},
		{name:"prepayAccountId", type:"int", useNull:true},
		{name:"prepayAccount", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.CustomerGroupAcctDsFilter" ,{
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
		{name:"custGroupId", type:"int", useNull:true},
		{name:"custGroupId_From",type:"int", useNull:true},
		{name:"custGroupId_To",type:"int", useNull:true},
		{name:"custGroup", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"salesAccountId", type:"int", useNull:true},
		{name:"salesAccountId_From",type:"int", useNull:true},
		{name:"salesAccountId_To",type:"int", useNull:true},
		{name:"salesAccount", type:"string"},
		{name:"prepayAccountId", type:"int", useNull:true},
		{name:"prepayAccountId_From",type:"int", useNull:true},
		{name:"prepayAccountId_To",type:"int", useNull:true},
		{name:"prepayAccount", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.CustomerGroupAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 