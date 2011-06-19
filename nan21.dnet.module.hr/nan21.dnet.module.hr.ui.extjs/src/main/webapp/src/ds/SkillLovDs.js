 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.SkillLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"ratingScaleId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.SkillLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.SkillLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SkillLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.SkillLovDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.SkillLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.SkillLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 