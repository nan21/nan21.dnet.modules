 
   	 
Ext.define("net.nan21.dnet.module.mm.price.ds.model.PriceListTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.mm.price.ds.model.PriceListTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.price.ds.param.PriceListTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 