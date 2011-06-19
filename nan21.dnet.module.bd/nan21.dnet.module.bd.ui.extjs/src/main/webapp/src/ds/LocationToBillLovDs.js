 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.LocationToBillLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"targetId",type:"int"}
	,	{name:"targetType",type:"string"}
	,	{name:"asString",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.LocationToBillLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.LocationToBillLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LocationToBillLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.LocationToBillLovDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.LocationToBillLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.LocationToBillLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 