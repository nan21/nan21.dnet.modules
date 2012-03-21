 
   	 
Ext.define("net.nan21.dnet.module.mm.price.ds.model.PriceListPurchaseLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"salesList", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.mm.price.ds.model.PriceListPurchaseLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"salesList", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.price.ds.param.PriceListPurchaseLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 