 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.SkillCategoryLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.SkillCategoryLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.SkillCategoryLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SkillCategoryLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.SkillCategoryLovDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.SkillCategoryLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.SkillCategoryLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 