 
   	 
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductManufacturerLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductManufacturerLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductManufacturerLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 