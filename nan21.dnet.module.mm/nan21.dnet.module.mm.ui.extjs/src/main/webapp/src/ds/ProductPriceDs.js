 
   	 
Ext.define("net.nan21.dnet.module.mm.price.ds.model.ProductPriceDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"priceListId",type:"int", useNull:true },
		{name:"productId",type:"int", useNull:true },
		{name:"product",type:"string" },
		{name:"productName",type:"string" },
		{name:"price",type:"float", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.mm.price.ds.model.ProductPriceDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"priceListId",type:"int", useNull:true },
		{name:"productId",type:"int", useNull:true },
		{name:"product",type:"string" },
		{name:"productName",type:"string" },
		{name:"price",type:"float", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.price.ds.param.ProductPriceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 