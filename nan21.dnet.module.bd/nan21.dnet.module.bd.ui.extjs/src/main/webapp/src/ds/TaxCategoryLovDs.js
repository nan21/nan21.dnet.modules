 
   	 
Ext.define("net.nan21.dnet.module.bd.fin.ds.model.TaxCategoryLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.fin.ds.model.TaxCategoryLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.fin.ds.param.TaxCategoryLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 