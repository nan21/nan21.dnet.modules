 
   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpAccountAcctDs" ,{
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
		{name:"bpAccountId", type:"int", useNull:true},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"custSalesAccountId", type:"int", useNull:true},
		{name:"custSalesAccount", type:"string"},
		{name:"custPrepayAccountId", type:"int", useNull:true},
		{name:"custPrepayAccount", type:"string"},
		{name:"vendorPurchaseAccountId", type:"int", useNull:true},
		{name:"vendorPurchaseAccount", type:"string"},
		{name:"vendorPrepayAccountId", type:"int", useNull:true},
		{name:"vendorPrepayAccount", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpAccountAcctDsFilter" ,{
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
		{name:"bpAccountId", type:"int", useNull:true},
		{name:"bpAccountId_From",type:"int", useNull:true},
		{name:"bpAccountId_To",type:"int", useNull:true},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"custSalesAccountId", type:"int", useNull:true},
		{name:"custSalesAccountId_From",type:"int", useNull:true},
		{name:"custSalesAccountId_To",type:"int", useNull:true},
		{name:"custSalesAccount", type:"string"},
		{name:"custPrepayAccountId", type:"int", useNull:true},
		{name:"custPrepayAccountId_From",type:"int", useNull:true},
		{name:"custPrepayAccountId_To",type:"int", useNull:true},
		{name:"custPrepayAccount", type:"string"},
		{name:"vendorPurchaseAccountId", type:"int", useNull:true},
		{name:"vendorPurchaseAccountId_From",type:"int", useNull:true},
		{name:"vendorPurchaseAccountId_To",type:"int", useNull:true},
		{name:"vendorPurchaseAccount", type:"string"},
		{name:"vendorPrepayAccountId", type:"int", useNull:true},
		{name:"vendorPrepayAccountId_From",type:"int", useNull:true},
		{name:"vendorPrepayAccountId_To",type:"int", useNull:true},
		{name:"vendorPrepayAccount", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.BpAccountAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 