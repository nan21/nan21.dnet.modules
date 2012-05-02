 
   	 
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAttributeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductAttributeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 