 
   	 
Ext.ns("net.nan21.dnet.module.bd.currency.ds.model");
	net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderDs = [
	{name:"name",type:"string"}
	,	{name:"code",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"notes",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds.param");	
	net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateProviderDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds");	
	net.nan21.dnet.module.bd.currency.ds.CurrencyXRateProviderDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CurrencyXRateProviderDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderDs
				,paramFields: net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateProviderDsParam				 
			});
		 	net.nan21.dnet.module.bd.currency.ds.CurrencyXRateProviderDs.superclass.constructor.call(this, config);
		}	 
	});  
 