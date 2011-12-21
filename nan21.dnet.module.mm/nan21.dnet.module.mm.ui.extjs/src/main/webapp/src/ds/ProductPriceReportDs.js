 
   	 
Ext.define("net.nan21.dnet.module.mm.price.ds.model.ProductPriceReportDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"priceListId",type:"int", useNull:true },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currency",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"productId",type:"int", useNull:true },
		{name:"product",type:"string" },
		{name:"productName",type:"string" },
		{name:"price",type:"float", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.mm.price.ds.model.ProductPriceReportDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"priceListId",type:"int", useNull:true },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currency",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"productId",type:"int", useNull:true },
		{name:"product",type:"string" },
		{name:"productName",type:"string" },
		{name:"price",type:"float", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.price.ds.param.ProductPriceReportDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 	
		{name:"validAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT},	
		{name:"productCategoryId",type:"int", useNull:true},	
		{name:"productCategory",type:"string"}
	]
}); 
 