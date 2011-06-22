 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfMyTaskDs = [
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
	net.nan21.dnet.module.ad.workflow.ds.param.WfMyTaskDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfMyTaskDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfMyTaskDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfMyTaskDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfMyTaskDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfMyTaskDs.superclass.constructor.call(this, config);
		}	 
	});  
 