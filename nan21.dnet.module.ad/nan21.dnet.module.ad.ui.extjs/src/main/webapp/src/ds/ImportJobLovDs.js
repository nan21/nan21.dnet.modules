 
   	 
Ext.ns("net.nan21.dnet.module.ad.impex.ds.model");
	net.nan21.dnet.module.ad.impex.ds.model.ImportJobLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds.param");	
	net.nan21.dnet.module.ad.impex.ds.param.ImportJobLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds");	
	net.nan21.dnet.module.ad.impex.ds.ImportJobLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ImportJobLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.impex.ds.model.ImportJobLovDs
				,paramFields: net.nan21.dnet.module.ad.impex.ds.param.ImportJobLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.impex.ds.ImportJobLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 