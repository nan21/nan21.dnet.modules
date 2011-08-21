 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs = [
	{name:"id",type:"string"}
	,	{name:"processId",type:"string"}
	,	{name:"process",type:"string"}
	,	{name:"taskKey",type:"string"}
	,	{name:"processInstanceId",type:"string"}
	,	{name:"executionId",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"description",type:"string"}
	,	{name:"owner",type:"string"}
	,	{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"priority",type:"int"}
	,	{name:"dueDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.ActMyTaskDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.ActMyTaskDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ActMyTaskDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.ActMyTaskDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.ActMyTaskDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.ActMyTaskDs.superclass.constructor.call(this, config);
		}	 
	});  
 