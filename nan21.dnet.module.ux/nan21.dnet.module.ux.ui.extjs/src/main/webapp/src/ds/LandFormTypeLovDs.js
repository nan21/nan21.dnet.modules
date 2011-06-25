 
   	 
Ext.ns("net.nan21.dnet.module.ux.example.ds.model");
	net.nan21.dnet.module.ux.example.ds.model.LandFormTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ux.example.ds.param");	
	net.nan21.dnet.module.ux.example.ds.param.LandFormTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ux.example.ds");	
	net.nan21.dnet.module.ux.example.ds.LandFormTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LandFormTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ux.example.ds.model.LandFormTypeLovDs
				,paramFields: net.nan21.dnet.module.ux.example.ds.param.LandFormTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.ux.example.ds.LandFormTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 