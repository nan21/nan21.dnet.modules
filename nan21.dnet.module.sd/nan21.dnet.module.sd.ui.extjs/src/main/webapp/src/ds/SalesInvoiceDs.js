 
   	 
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.model");
	net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"docNo",type:"string"}
	,	{name:"docDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"statusId",type:"int"}
	,	{name:"status",type:"string"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"currencyId",type:"int"}
	,	{name:"currencyCode",type:"string"}
	,	{name:"totalNetAmount",type:"float"}
	,	{name:"totalTaxAmount",type:"float"}
	,	{name:"totalAmount",type:"float"}
	,	{name:"customerId",type:"int"}
	,	{name:"customerCode",type:"string"}
	,	{name:"billToLocationId",type:"int"}
	,	{name:"billToLocation",type:"string"}
	,	{name:"billToContactId",type:"int"}
	,	{name:"billToContact",type:"string"}
	,	{name:"supplierId",type:"int"}
	,	{name:"supplierCode",type:"string"}
	,	{name:"salesOrderId",type:"int"}
	,	{name:"className",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.param");	
	net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds");	
	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesInvoiceDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs
				,paramFields: net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceDsParam				 
			});
		 	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceDs.superclass.constructor.call(this, config);
		}	 
	});  
 