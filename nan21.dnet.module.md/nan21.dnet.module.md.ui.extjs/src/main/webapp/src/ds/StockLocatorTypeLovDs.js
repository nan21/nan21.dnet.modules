 
   	 
Ext.define("net.nan21.dnet.module.md.org.ds.model.StockLocatorTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.md.org.ds.model.StockLocatorTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.org.ds.param.StockLocatorTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 