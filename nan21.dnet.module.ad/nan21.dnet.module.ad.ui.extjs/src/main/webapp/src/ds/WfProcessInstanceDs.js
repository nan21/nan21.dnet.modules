 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfProcessInstanceDs = [
	{name:"id",type:"string"}
	,	{name:"processInstanceId",type:"string"}
	,	{name:"processId",type:"string"}
	,	{name:"process",type:"string"}
	,	{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"duration",type:"int"}
	,	{name:"startedBy",type:"string"}
	,	{name:"startAction",type:"string"}
	,	{name:"endAction",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfProcessInstanceDsParam = [
	{name:"processFullName",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfProcessInstanceDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfProcessInstanceDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfProcessInstanceDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfProcessInstanceDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfProcessInstanceDs.superclass.constructor.call(this, config);
		}	 
	});  
 