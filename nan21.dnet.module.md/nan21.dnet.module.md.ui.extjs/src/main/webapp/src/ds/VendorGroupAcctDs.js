/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.VendorGroupAcctDs" ,{
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
		{name:"vendorGroupId", type:"int", useNull:true},
		{name:"vendorGroup", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"purchaseAccountId", type:"int", useNull:true},
		{name:"purchaseAccount", type:"string"},
		{name:"prepayAccountId", type:"int", useNull:true},
		{name:"prepayAccount", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.VendorGroupAcctDsFilter" ,{
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
		{name:"vendorGroupId", type:"int", useNull:true},
		{name:"vendorGroupId_From",type:"int", useNull:true},
		{name:"vendorGroupId_To",type:"int", useNull:true},
		{name:"vendorGroup", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"purchaseAccountId", type:"int", useNull:true},
		{name:"purchaseAccountId_From",type:"int", useNull:true},
		{name:"purchaseAccountId_To",type:"int", useNull:true},
		{name:"purchaseAccount", type:"string"},
		{name:"prepayAccountId", type:"int", useNull:true},
		{name:"prepayAccountId_From",type:"int", useNull:true},
		{name:"prepayAccountId_To",type:"int", useNull:true},
		{name:"prepayAccount", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.VendorGroupAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 