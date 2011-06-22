 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfDeploymentDs = [
	{name:"id",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"deployTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"fullName",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfDeploymentDsParam = [
	{name:"from",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"to",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfDeploymentDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfDeploymentDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfDeploymentDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfDeploymentDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfDeploymentDs.superclass.constructor.call(this, config);
		}	 
	});  
 