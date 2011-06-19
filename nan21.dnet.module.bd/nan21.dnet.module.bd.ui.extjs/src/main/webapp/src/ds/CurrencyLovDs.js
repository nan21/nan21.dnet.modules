 
   	 
Ext.ns("net.nan21.dnet.module.bd.currency.ds.model");
	net.nan21.dnet.module.bd.currency.ds.model.CurrencyLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds.param");	
	net.nan21.dnet.module.bd.currency.ds.param.CurrencyLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.currency.ds");	
	net.nan21.dnet.module.bd.currency.ds.CurrencyLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CurrencyLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.currency.ds.model.CurrencyLovDs
				,paramFields: net.nan21.dnet.module.bd.currency.ds.param.CurrencyLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.currency.ds.CurrencyLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 