 
   	 
Ext.ns("net.nan21.dnet.module.bd.currency.ds.model");
	net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds.param");	
	net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateProviderLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds");	
	net.nan21.dnet.module.bd.currency.ds.CurrencyXRateProviderLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CurrencyXRateProviderLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderLovDs
				,paramFields: net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateProviderLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.currency.ds.CurrencyXRateProviderLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 