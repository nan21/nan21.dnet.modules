 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs = [
	{name:"id",type:"string"}
	,	{name:"processInstanceId",type:"string"}
	,	{name:"processId",type:"string"}
	,	{name:"process",type:"string"}
	,	{name:"processVersion",type:"int"}
	,	{name:"startTime",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"startedBy",type:"string"}
	,	{name:"startAction",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceDsParam = [
	{name:"processFullName",type:"string"}
	,	{name:"reasonToKill",type:"string"}
	,	{name:"from",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"to",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.ActProcessInstanceDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ActProcessInstanceDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.ActProcessInstanceDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.ActProcessInstanceDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.ActProcessInstanceDs.superclass.constructor.call(this, config);
		}	 
	});  
 