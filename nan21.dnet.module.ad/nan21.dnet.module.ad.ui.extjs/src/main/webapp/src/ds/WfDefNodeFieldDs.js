 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeFieldDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"required",type:"boolean"}
	,	{name:"nodeId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeFieldDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfDefNodeFieldDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfDefNodeFieldDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeFieldDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeFieldDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfDefNodeFieldDs.superclass.constructor.call(this, config);
		}	 
	});  
 