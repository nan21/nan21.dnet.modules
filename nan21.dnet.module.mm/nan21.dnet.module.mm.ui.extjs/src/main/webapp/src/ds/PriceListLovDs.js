 
   	 
Ext.define("net.nan21.dnet.module.mm.price.ds.model.PriceListLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currency",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.mm.price.ds.model.PriceListLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currency",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.price.ds.param.PriceListLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 