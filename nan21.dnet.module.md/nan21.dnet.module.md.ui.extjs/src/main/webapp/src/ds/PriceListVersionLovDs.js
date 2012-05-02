 
   	 
Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"priceListId", type:"int", useNull:true},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.PriceListVersionLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"priceListId", type:"int", useNull:true},
		{name:"priceListId_From",type:"int", useNull:true},
		{name:"priceListId_To",type:"int", useNull:true},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.mm.price.ds.param.PriceListVersionLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 