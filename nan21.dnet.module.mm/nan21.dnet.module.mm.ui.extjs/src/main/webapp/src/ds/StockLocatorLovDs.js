 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"subInventoryId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"subInventoryId", type:"int", useNull:true},
		{name:"subInventoryId_From",type:"int", useNull:true},
		{name:"subInventoryId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 