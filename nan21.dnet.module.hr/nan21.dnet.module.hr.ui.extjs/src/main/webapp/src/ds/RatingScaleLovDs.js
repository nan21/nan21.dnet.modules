 
   	 
Ext.define("net.nan21.dnet.module.hr.skill.ds.model.RatingScaleLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.hr.skill.ds.model.RatingScaleLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.skill.ds.param.RatingScaleLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 