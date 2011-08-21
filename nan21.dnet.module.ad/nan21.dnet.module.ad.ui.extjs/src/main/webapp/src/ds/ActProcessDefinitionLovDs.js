 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDs = [
	{name:"id",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"fullName",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.ActProcessDefinitionLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ActProcessDefinitionLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.ActProcessDefinitionLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 