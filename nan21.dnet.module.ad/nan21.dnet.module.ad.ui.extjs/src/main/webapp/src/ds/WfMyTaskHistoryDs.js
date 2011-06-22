 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfMyTaskHistoryDs = [
	{name:"id",type:"string"}
	,	{name:"processId",type:"string"}
	,	{name:"taskKey",type:"string"}
	,	{name:"processInstanceId",type:"string"}
	,	{name:"executionId",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"description",type:"string"}
	,	{name:"owner",type:"string"}
	,	{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"duration",type:"int"}
	,	{name:"deleteReason",type:"string"}
	,	{name:"priority",type:"int"}
	,	{name:"dueDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfMyTaskHistoryDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfMyTaskHistoryDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfMyTaskHistoryDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfMyTaskHistoryDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfMyTaskHistoryDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfMyTaskHistoryDs.superclass.constructor.call(this, config);
		}	 
	});  
 