 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.PositionSkillDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"positionId",type:"int"}
	,	{name:"competenceId",type:"int"}
	,	{name:"competence",type:"string"}
	,	{name:"ratingScaleId",type:"int"}
	,	{name:"requiredLevelId",type:"int"}
	,	{name:"requiredLevel",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.PositionSkillDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.PositionSkillDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PositionSkillDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.PositionSkillDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.PositionSkillDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.PositionSkillDs.superclass.constructor.call(this, config);
		}	 
	});  
 