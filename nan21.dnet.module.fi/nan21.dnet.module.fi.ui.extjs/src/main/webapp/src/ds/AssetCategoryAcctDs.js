/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.fi.asset.ds.model.AssetCategoryAcctDs" ,{
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
		{name:"assetCategoryId", type:"int", useNull:true},
		{name:"assetCategory", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"deprecAccountId", type:"int", useNull:true},
		{name:"deprecAccount", type:"string"},
		{name:"acmlDeprecAccountId", type:"int", useNull:true},
		{name:"acmlDeprecAccount", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.fi.asset.ds.model.AssetCategoryAcctDsFilter" ,{
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
		{name:"assetCategoryId", type:"int", useNull:true},
		{name:"assetCategoryId_From",type:"int", useNull:true},
		{name:"assetCategoryId_To",type:"int", useNull:true},
		{name:"assetCategory", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"deprecAccountId", type:"int", useNull:true},
		{name:"deprecAccountId_From",type:"int", useNull:true},
		{name:"deprecAccountId_To",type:"int", useNull:true},
		{name:"deprecAccount", type:"string"},
		{name:"acmlDeprecAccountId", type:"int", useNull:true},
		{name:"acmlDeprecAccountId_From",type:"int", useNull:true},
		{name:"acmlDeprecAccountId_To",type:"int", useNull:true},
		{name:"acmlDeprecAccount", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.fi.asset.ds.param.AssetCategoryAcctDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 