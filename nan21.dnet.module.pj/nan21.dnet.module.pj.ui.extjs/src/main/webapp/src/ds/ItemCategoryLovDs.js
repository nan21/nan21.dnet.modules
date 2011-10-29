 
   	 
Ext.define("net.nan21.dnet.module.pj.base.ds.model.ItemCategoryLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.pj.base.ds.model.ItemCategoryLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.base.ds.param.ItemCategoryLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 