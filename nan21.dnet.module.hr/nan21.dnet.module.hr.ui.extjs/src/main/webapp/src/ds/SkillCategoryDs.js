 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.SkillCategoryDs = [
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
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.SkillCategoryDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.SkillCategoryDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SkillCategoryDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.SkillCategoryDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.SkillCategoryDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.SkillCategoryDs.superclass.constructor.call(this, config);
		}	 
	});  
 