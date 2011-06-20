 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"employeeId",type:"int"}
	,	{name:"skillId",type:"int"}
	,	{name:"skill",type:"string"}
	,	{name:"ratingScaleId",type:"int"}
	,	{name:"skillLevelId",type:"int"}
	,	{name:"skillLevel",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.EmployeeSkillDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.EmployeeSkillDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmployeeSkillDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.EmployeeSkillDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.EmployeeSkillDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.EmployeeSkillDs.superclass.constructor.call(this, config);
		}	 
	});  
 