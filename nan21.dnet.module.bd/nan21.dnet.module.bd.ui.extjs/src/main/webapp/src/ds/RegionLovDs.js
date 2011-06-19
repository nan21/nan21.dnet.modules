 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.RegionLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.RegionLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.RegionLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"RegionLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.RegionLovDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.RegionLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.RegionLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 