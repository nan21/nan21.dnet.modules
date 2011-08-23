 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs = [
	{name:"id",type:"string"}
	,	{name:"processId",type:"string"}
	,	{name:"process",type:"string"}
	,	{name:"taskKey",type:"string"}
	,	{name:"processInstanceId",type:"string"}
	,	{name:"executionId",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"description",type:"string"}
	,	{name:"assignee",type:"string"}
	,	{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"duration",type:"int"}
	,	{name:"priority",type:"int"}
	,	{name:"dueDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceDsParam = [
	{name:"hideActive",type:"boolean"}
	,	{name:"hideCompleted",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.ActTaskInstanceDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ActTaskInstanceDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.ActTaskInstanceDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.ActTaskInstanceDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.ActTaskInstanceDs.superclass.constructor.call(this, config);
		}	 
	});  
 