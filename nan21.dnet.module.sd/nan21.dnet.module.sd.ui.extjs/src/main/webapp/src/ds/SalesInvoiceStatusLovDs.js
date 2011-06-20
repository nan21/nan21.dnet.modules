 
   	 
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.model");
	net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceStatusLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"sequenceNo",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds.param");	
	net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceStatusLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.invoice.ds");	
	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceStatusLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesInvoiceStatusLovDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceStatusLovDs
				,paramFields: net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceStatusLovDsParam				 
			});
		 	net.nan21.dnet.module.sd.invoice.ds.SalesInvoiceStatusLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 