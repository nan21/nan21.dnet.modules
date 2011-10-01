 
   	 
Ext.define("net.nan21.dnet.module.sd.price.ds.model.PriceListLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.sd.price.ds.param.PriceListLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 