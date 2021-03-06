/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs" ,{
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
		{name:"code", type:"string"},
		{name:"docNo", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"customerId", type:"int", useNull:true},
		{name:"customer", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplierUuid", type:"string"},
		{name:"supplierCode", type:"string"},
		{name:"supplier", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docType", type:"string"},
		{name:"description", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodType", type:"string"},
		{name:"paymentTermId", type:"int", useNull:true},
		{name:"paymentTerm", type:"string"},
		{name:"selfPayed", type:"boolean"},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"fromAccount", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"totalNetAmount", type:"float", useNull:true},
		{name:"totalTaxAmount", type:"float", useNull:true},
		{name:"totalAmount", type:"float", useNull:true},
		{name:"confirmed", type:"boolean"},
		{name:"posted", type:"boolean"},
		{name:"purchaseOrderId", type:"int", useNull:true},
		{name:"className", type:"string"},
		{name:"businessObject", type:"string"}
	],
	validations: [  
		{field: "docDate", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDsFilter" ,{
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
		{name:"code", type:"string"},
		{name:"docNo", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"customerId", type:"int", useNull:true},
		{name:"customerId_From",type:"int", useNull:true},
		{name:"customerId_To",type:"int", useNull:true},
		{name:"customer", type:"string"},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplierId_From",type:"int", useNull:true},
		{name:"supplierId_To",type:"int", useNull:true},
		{name:"supplierUuid", type:"string"},
		{name:"supplierCode", type:"string"},
		{name:"supplier", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docTypeId_From",type:"int", useNull:true},
		{name:"docTypeId_To",type:"int", useNull:true},
		{name:"docType", type:"string"},
		{name:"description", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethodId_From",type:"int", useNull:true},
		{name:"paymentMethodId_To",type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodType", type:"string"},
		{name:"paymentTermId", type:"int", useNull:true},
		{name:"paymentTermId_From",type:"int", useNull:true},
		{name:"paymentTermId_To",type:"int", useNull:true},
		{name:"paymentTerm", type:"string"},
		{name:"selfPayed", type:"boolean", useNull:true},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"fromAccountId_From",type:"int", useNull:true},
		{name:"fromAccountId_To",type:"int", useNull:true},
		{name:"fromAccount", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"totalNetAmount", type:"float", useNull:true},
		{name:"totalNetAmount_From",type:"float", useNull:true},
		{name:"totalNetAmount_To",type:"float", useNull:true},
		{name:"totalTaxAmount", type:"float", useNull:true},
		{name:"totalTaxAmount_From",type:"float", useNull:true},
		{name:"totalTaxAmount_To",type:"float", useNull:true},
		{name:"totalAmount", type:"float", useNull:true},
		{name:"totalAmount_From",type:"float", useNull:true},
		{name:"totalAmount_To",type:"float", useNull:true},
		{name:"confirmed", type:"boolean", useNull:true},
		{name:"posted", type:"boolean", useNull:true},
		{name:"purchaseOrderId", type:"int", useNull:true},
		{name:"purchaseOrderId_From",type:"int", useNull:true},
		{name:"purchaseOrderId_To",type:"int", useNull:true},
		{name:"className", type:"string"},
		{name:"businessObject", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 