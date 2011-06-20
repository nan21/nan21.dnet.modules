 
   	 
Ext.ns("net.nan21.dnet.module.hr.job.ds.model");
	net.nan21.dnet.module.hr.job.ds.model.WorkRequirementDs = [
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
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds.param");	
	net.nan21.dnet.module.hr.job.ds.param.WorkRequirementDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds");	
	net.nan21.dnet.module.hr.job.ds.WorkRequirementDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WorkRequirementDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.job.ds.model.WorkRequirementDs
				,paramFields: net.nan21.dnet.module.hr.job.ds.param.WorkRequirementDsParam				 
			});
		 	net.nan21.dnet.module.hr.job.ds.WorkRequirementDs.superclass.constructor.call(this, config);
		}	 
	});  
 