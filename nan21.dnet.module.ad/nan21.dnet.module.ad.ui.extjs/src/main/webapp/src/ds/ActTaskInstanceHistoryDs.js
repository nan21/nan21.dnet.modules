 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceHistoryDs = [
	{name:"id",type:"string"}
	,	{name:"taskDefinitionKey",type:"string"}
	,	{name:"processInstanceId",type:"string"}
	,	{name:"processDefinitionId",type:"string"}
	,	{name:"executionId",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"description",type:"string"}
	,	{name:"assignee",type:"string"}
	,	{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"duration",type:"int"}
	,	{name:"deleteReason",type:"string"}
	,	{name:"priority",type:"int"}
	,	{name:"dueDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceHistoryDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.ActTaskInstanceHistoryDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ActTaskInstanceHistoryDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceHistoryDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceHistoryDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.ActTaskInstanceHistoryDs.superclass.constructor.call(this, config);
		}	 
	});  
 