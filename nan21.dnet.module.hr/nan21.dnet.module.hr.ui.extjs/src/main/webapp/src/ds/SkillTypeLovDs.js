 
   	 
Ext.ns("net.nan21.dnet.module.hr.skill.ds.model");
	net.nan21.dnet.module.hr.skill.ds.model.SkillTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds.param");	
	net.nan21.dnet.module.hr.skill.ds.param.SkillTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.skill.ds");	
	net.nan21.dnet.module.hr.skill.ds.SkillTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SkillTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.skill.ds.model.SkillTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.skill.ds.param.SkillTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.skill.ds.SkillTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 