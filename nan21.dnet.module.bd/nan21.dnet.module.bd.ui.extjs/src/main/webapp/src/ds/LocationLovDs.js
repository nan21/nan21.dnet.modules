 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.LocationLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"targetId",type:"int"}
	,	{name:"targetType",type:"string"}
	,	{name:"asString",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.LocationLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.LocationLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LocationLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.LocationLovDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.LocationLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.LocationLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 