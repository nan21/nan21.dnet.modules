 
   	 
Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"payScaleId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScalePointLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"payScaleId", type:"int", useNull:true},
		{name:"payScaleId_From",type:"int", useNull:true},
		{name:"payScaleId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.grade.ds.param.PayScalePointLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 