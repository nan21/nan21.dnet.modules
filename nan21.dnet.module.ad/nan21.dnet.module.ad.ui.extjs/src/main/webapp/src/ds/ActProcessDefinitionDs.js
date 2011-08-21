 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs = [
	{name:"id",type:"string"}
	,	{name:"key",type:"string"}
	,	{name:"fullName",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"category",type:"string"}
	,	{name:"resourceName",type:"string"}
	,	{name:"diagramResourceName",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"deploymentId",type:"string"}
	,	{name:"hasStartForm",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionDsParam = [
	{name:"deployment",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.ActProcessDefinitionDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ActProcessDefinitionDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.ActProcessDefinitionDs.superclass.constructor.call(this, config);
		}	 
	});  
 