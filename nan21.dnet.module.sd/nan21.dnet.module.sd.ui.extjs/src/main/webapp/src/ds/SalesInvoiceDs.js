 
   	 
Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"docNo",type:"string" },
		{name:"docDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"businessObject",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"status",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currencyCode",type:"string" },
		{name:"totalNetAmount",type:"float", useNull:true },
		{name:"totalTaxAmount",type:"float", useNull:true },
		{name:"totalAmount",type:"float", useNull:true },
		{name:"customerId",type:"int", useNull:true },
		{name:"customerCode",type:"string" },
		{name:"billToLocationId",type:"int", useNull:true },
		{name:"billToLocation",type:"string" },
		{name:"billToContactId",type:"int", useNull:true },
		{name:"billToContact",type:"string" },
		{name:"supplierId",type:"int", useNull:true },
		{name:"supplierCode",type:"string" },
		{name:"salesOrderId",type:"int", useNull:true },
		{name:"className",type:"string" }
	],
	validations: [  
		{field: "docNo", type: 'presence'}, 
		{field: "docDate", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 