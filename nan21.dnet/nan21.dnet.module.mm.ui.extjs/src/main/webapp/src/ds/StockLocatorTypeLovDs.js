 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 