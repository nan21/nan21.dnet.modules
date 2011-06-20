 
   	 
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.model");
	net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceStatusDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"sequenceNo",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.param");	
	net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceStatusDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds");	
	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceStatusDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesInvoiceStatusDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceStatusDs
				,paramFields: net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceStatusDsParam				 
			});
		 	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceStatusDs.superclass.constructor.call(this, config);
		}	 
	});  
 