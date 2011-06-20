 
   	 
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.model");
	net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.param");	
	net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds");	
	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesInvoiceTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTypeLovDs
				,paramFields: net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 