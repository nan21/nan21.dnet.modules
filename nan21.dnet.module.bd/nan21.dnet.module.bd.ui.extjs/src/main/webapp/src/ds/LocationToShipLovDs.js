 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.LocationToShipLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"targetId",type:"int"}
	,	{name:"targetType",type:"string"}
	,	{name:"asString",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.LocationToShipLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.LocationToShipLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LocationToShipLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.LocationToShipLovDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.LocationToShipLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.LocationToShipLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 