 
   	 
Ext.define("net.nan21.dnet.module.mm.price.ds.model.PriceListVersionDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"priceListId",type:"int", useNull:true },
		{name:"priceList",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.mm.price.ds.model.PriceListVersionDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"priceListId",type:"int", useNull:true },
		{name:"priceList",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.price.ds.param.PriceListVersionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 	
		{name:"productCategoryId",type:"int", useNull:true},	
		{name:"productCategory",type:"string"},	
		{name:"copyFromVersionId",type:"int", useNull:true},	
		{name:"copyFromVersion",type:"string"}
	]
}); 
 