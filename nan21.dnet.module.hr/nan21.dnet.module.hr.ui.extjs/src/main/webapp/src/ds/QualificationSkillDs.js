 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"qualificationId",type:"int"}
	,	{name:"skillId",type:"int"}
	,	{name:"skill",type:"string"}
	,	{name:"ratingScaleId",type:"int"}
	,	{name:"requiredLevelId",type:"int"}
	,	{name:"requiredLevel",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.QualificationSkillDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.QualificationSkillDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"QualificationSkillDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.QualificationSkillDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.QualificationSkillDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.QualificationSkillDs.superclass.constructor.call(this, config);
		}	 
	});  
 