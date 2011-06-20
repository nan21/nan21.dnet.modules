 
   	 
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.model");
	net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"invoiceId",type:"int"}
	,	{name:"itemId",type:"int"}
	,	{name:"itemCode",type:"string"}
	,	{name:"itemName",type:"string"}
	,	{name:"quantity",type:"float"}
	,	{name:"uomId",type:"int"}
	,	{name:"uomCode",type:"string"}
	,	{name:"unitPrice",type:"float"}
	,	{name:"netAmount",type:"float"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.param");	
	net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceItemDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds");	
	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceItemDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesInvoiceItemDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDs
				,paramFields: net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceItemDsParam				 
			});
		 	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceItemDs.superclass.constructor.call(this, config);
		}	 
	});  
 