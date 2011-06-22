 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"processId",type:"int"}
	,	{name:"process",type:"string"}
	,	{name:"sourceId",type:"int"}
	,	{name:"source",type:"string"}
	,	{name:"targetId",type:"int"}
	,	{name:"target",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfDefTransitionDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfDefTransitionDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfDefTransitionDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfDefTransitionDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfDefTransitionDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfDefTransitionDs.superclass.constructor.call(this, config);
		}	 
	});  
 