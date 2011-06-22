 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"processId",type:"int"}
	,	{name:"process",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfDefNodeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfDefNodeDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfDefNodeDs.superclass.constructor.call(this, config);
		}	 
	});  
 