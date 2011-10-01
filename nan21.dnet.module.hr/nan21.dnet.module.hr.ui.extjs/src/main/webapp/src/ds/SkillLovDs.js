 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.SkillLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"ratingScaleId",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.SkillLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 