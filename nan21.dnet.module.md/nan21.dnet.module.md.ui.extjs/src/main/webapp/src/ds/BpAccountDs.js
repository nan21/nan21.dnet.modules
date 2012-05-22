/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpAccountDs" ,{
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
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartner", type:"string"},
		{name:"customer", type:"boolean"},
		{name:"vendor", type:"boolean"},
		{name:"organizationId", type:"int", useNull:true},
		{name:"organization", type:"string"},
		{name:"customerGroupId", type:"int", useNull:true},
		{name:"customerGroup", type:"string"},
		{name:"customerPaymentMethodId", type:"int", useNull:true},
		{name:"customerPaymentMethod", type:"string"},
		{name:"customerCreditLimit", type:"float", useNull:true},
		{name:"customerPaymentTermId", type:"int", useNull:true},
		{name:"customerPaymentTerm", type:"string"},
		{name:"vendorGroupId", type:"int", useNull:true},
		{name:"vendorGroup", type:"string"},
		{name:"vendorPaymentMethodId", type:"int", useNull:true},
		{name:"vendorPaymentMethod", type:"string"},
		{name:"vendorCreditLimit", type:"float", useNull:true},
		{name:"vendorPaymentTermId", type:"int", useNull:true},
		{name:"vendorPaymentTerm", type:"string"},
		{name:"analiticSegment", type:"string"},
		{name:"custAnaliticSegment", type:"string"},
		{name:"vendAnaliticSegment", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpAccountDsFilter" ,{
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
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartnerId_From",type:"int", useNull:true},
		{name:"businessPartnerId_To",type:"int", useNull:true},
		{name:"businessPartner", type:"string"},
		{name:"customer", type:"boolean", useNull:true},
		{name:"vendor", type:"boolean", useNull:true},
		{name:"organizationId", type:"int", useNull:true},
		{name:"organizationId_From",type:"int", useNull:true},
		{name:"organizationId_To",type:"int", useNull:true},
		{name:"organization", type:"string"},
		{name:"customerGroupId", type:"int", useNull:true},
		{name:"customerGroupId_From",type:"int", useNull:true},
		{name:"customerGroupId_To",type:"int", useNull:true},
		{name:"customerGroup", type:"string"},
		{name:"customerPaymentMethodId", type:"int", useNull:true},
		{name:"customerPaymentMethodId_From",type:"int", useNull:true},
		{name:"customerPaymentMethodId_To",type:"int", useNull:true},
		{name:"customerPaymentMethod", type:"string"},
		{name:"customerCreditLimit", type:"float", useNull:true},
		{name:"customerCreditLimit_From",type:"float", useNull:true},
		{name:"customerCreditLimit_To",type:"float", useNull:true},
		{name:"customerPaymentTermId", type:"int", useNull:true},
		{name:"customerPaymentTermId_From",type:"int", useNull:true},
		{name:"customerPaymentTermId_To",type:"int", useNull:true},
		{name:"customerPaymentTerm", type:"string"},
		{name:"vendorGroupId", type:"int", useNull:true},
		{name:"vendorGroupId_From",type:"int", useNull:true},
		{name:"vendorGroupId_To",type:"int", useNull:true},
		{name:"vendorGroup", type:"string"},
		{name:"vendorPaymentMethodId", type:"int", useNull:true},
		{name:"vendorPaymentMethodId_From",type:"int", useNull:true},
		{name:"vendorPaymentMethodId_To",type:"int", useNull:true},
		{name:"vendorPaymentMethod", type:"string"},
		{name:"vendorCreditLimit", type:"float", useNull:true},
		{name:"vendorCreditLimit_From",type:"float", useNull:true},
		{name:"vendorCreditLimit_To",type:"float", useNull:true},
		{name:"vendorPaymentTermId", type:"int", useNull:true},
		{name:"vendorPaymentTermId_From",type:"int", useNull:true},
		{name:"vendorPaymentTermId_To",type:"int", useNull:true},
		{name:"vendorPaymentTerm", type:"string"},
		{name:"analiticSegment", type:"string"},
		{name:"custAnaliticSegment", type:"string"},
		{name:"vendAnaliticSegment", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.BpAccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 