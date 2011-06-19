 
   	 
Ext.ns("net.nan21.dnet.module.ad.impex.ds.model");
	net.nan21.dnet.module.ad.impex.ds.model.ImportMapLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds.param");	
	net.nan21.dnet.module.ad.impex.ds.param.ImportMapLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds");	
	net.nan21.dnet.module.ad.impex.ds.ImportMapLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ImportMapLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.impex.ds.model.ImportMapLovDs
				,paramFields: net.nan21.dnet.module.ad.impex.ds.param.ImportMapLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.impex.ds.ImportMapLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 