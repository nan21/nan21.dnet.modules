 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.SkillTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.SkillTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 