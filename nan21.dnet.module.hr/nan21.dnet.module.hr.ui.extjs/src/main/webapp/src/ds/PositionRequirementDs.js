 
   	 
Ext.ns("net.nan21.dnet.module.hr.job.ds.model");
	net.nan21.dnet.module.hr.job.ds.model.PositionRequirementDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"positionId",type:"int"}
	,	{name:"requirementId",type:"int"}
	,	{name:"requirement",type:"string"}
	,	{name:"notes",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds.param");	
	net.nan21.dnet.module.hr.job.ds.param.PositionRequirementDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds");	
	net.nan21.dnet.module.hr.job.ds.PositionRequirementDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PositionRequirementDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.job.ds.model.PositionRequirementDs
				,paramFields: net.nan21.dnet.module.hr.job.ds.param.PositionRequirementDsParam				 
			});
		 	net.nan21.dnet.module.hr.job.ds.PositionRequirementDs.superclass.constructor.call(this, config);
		}	 
	});  
 