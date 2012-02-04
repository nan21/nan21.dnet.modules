 
   	 
Ext.define("net.nan21.dnet.module.hr.grade.ds.model.GradeRateLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.hr.grade.ds.model.GradeRateLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.grade.ds.param.GradeRateLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 