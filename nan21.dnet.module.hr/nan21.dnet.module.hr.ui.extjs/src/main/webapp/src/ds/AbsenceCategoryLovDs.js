 
   	 
Ext.define("net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.time.ds.param.AbsenceCategoryLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 