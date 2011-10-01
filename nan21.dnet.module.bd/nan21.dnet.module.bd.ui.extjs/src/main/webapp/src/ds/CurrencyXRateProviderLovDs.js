 
   	 
Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateProviderLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateProviderLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 