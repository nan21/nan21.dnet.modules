 
   	 
Ext.ns("net.nan21.dnet.module.bd.currency.ds.model");
	net.nan21.dnet.module.bd.currency.ds.model.CurrencyDs = [
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
	,	{name:"iso3",type:"string"}
	,	{name:"standardPrecision",type:"int"}
	,	{name:"symbol",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds.param");	
	net.nan21.dnet.module.bd.currency.ds.param.CurrencyDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds");	
	net.nan21.dnet.module.bd.currency.ds.CurrencyDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CurrencyDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.currency.ds.model.CurrencyDs
				,paramFields: net.nan21.dnet.module.bd.currency.ds.param.CurrencyDsParam				 
			});
		 	net.nan21.dnet.module.bd.currency.ds.CurrencyDs.superclass.constructor.call(this, config);
		}	 
	});  
 