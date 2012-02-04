 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.SkillCategoryLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.hr.skill.ds.model.SkillCategoryLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.SkillCategoryLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 