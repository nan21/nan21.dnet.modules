 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.CountryLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.CountryLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.CountryLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CountryLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.CountryLovDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.CountryLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.CountryLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 