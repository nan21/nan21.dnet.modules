 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfProcessDs = [
	{name:"id",type:"string"}
	,	{name:"code",type:"string"}
	,	{name:"fullName",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"category",type:"string"}
	,	{name:"resourceName",type:"string"}
	,	{name:"diagramResourceName",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"deploymentId",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfProcessDsParam = [
	{name:"deployment",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfProcessDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfProcessDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfProcessDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfProcessDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfProcessDs.superclass.constructor.call(this, config);
		}	 
	});  
 