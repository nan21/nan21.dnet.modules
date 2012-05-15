/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"priceListVersionId", type:"int", useNull:true},
		{name:"priceListVersion", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"product", type:"string"},
		{name:"productName", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uom", type:"string"},
		{name:"price", type:"float", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.price.ds.model.ProductPriceDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"priceListVersionId", type:"int", useNull:true},
		{name:"priceListVersionId_From",type:"int", useNull:true},
		{name:"priceListVersionId_To",type:"int", useNull:true},
		{name:"priceListVersion", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"product", type:"string"},
		{name:"productName", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true},
		{name:"uom", type:"string"},
		{name:"price", type:"float", useNull:true},
		{name:"price_From",type:"float", useNull:true},
		{name:"price_To",type:"float", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.mm.price.ds.param.ProductPriceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"productCategoryId", type:"int", useNull:true},
		{name:"productCategory", type:"string"}
	]
}); 
 