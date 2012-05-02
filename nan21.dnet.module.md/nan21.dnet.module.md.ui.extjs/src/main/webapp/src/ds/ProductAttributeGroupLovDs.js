 
   	 
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeGroupLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeGroupLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductAttributeGroupLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 