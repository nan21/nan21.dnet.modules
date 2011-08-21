 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDs = [
	{name:"id",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"fullName",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.ActDeploymentLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.ActDeploymentLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ActDeploymentLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentLovDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.ActDeploymentLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.ActDeploymentLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 