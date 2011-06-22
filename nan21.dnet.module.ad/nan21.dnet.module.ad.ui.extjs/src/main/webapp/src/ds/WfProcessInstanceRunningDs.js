 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfProcessInstanceRunningDs = [
	{name:"id",type:"string"}
	,	{name:"processInstanceId",type:"string"}
	,	{name:"processId",type:"string"}
	,	{name:"process",type:"string"}
	,	{name:"processVersion",type:"int"}
	,	{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"duration",type:"int"}
	,	{name:"startedBy",type:"string"}
	,	{name:"startAction",type:"string"}
	,	{name:"endAction",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfProcessInstanceRunningDsParam = [
	{name:"processFullName",type:"string"}
	,	{name:"reasonToKill",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfProcessInstanceRunningDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfProcessInstanceRunningDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfProcessInstanceRunningDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfProcessInstanceRunningDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfProcessInstanceRunningDs.superclass.constructor.call(this, config);
		}	 
	});  
 