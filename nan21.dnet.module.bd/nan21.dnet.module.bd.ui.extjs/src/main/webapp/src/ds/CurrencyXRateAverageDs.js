 
   	 
Ext.ns("net.nan21.dnet.module.bd.currency.ds.model");
	net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateAverageDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"sourceId",type:"int"}
	,	{name:"sourceCode",type:"string"}
	,	{name:"targetId",type:"int"}
	,	{name:"targetCode",type:"string"}
	,	{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"value",type:"float"}
	,	{name:"providerId",type:"int"}
	,	{name:"providerCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds.param");	
	net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateAverageDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds");	
	net.nan21.dnet.module.bd.currency.ds.CurrencyXRateAverageDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CurrencyXRateAverageDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateAverageDs
				,paramFields: net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateAverageDsParam				 
			});
		 	net.nan21.dnet.module.bd.currency.ds.CurrencyXRateAverageDs.superclass.constructor.call(this, config);
		}	 
	});  
 