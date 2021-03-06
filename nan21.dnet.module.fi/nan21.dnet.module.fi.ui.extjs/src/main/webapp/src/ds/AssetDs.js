/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.fi.asset.ds.model.AssetDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"categoryId", type:"int", useNull:true},
		{name:"category", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productName", type:"string"},
		{name:"withDepreciation", type:"boolean"},
		{name:"method", type:"string"},
		{name:"calculation", type:"string"},
		{name:"periodType", type:"string"},
		{name:"periodValue", type:"int", useNull:true},
		{name:"periodPercenatge", type:"int", useNull:true},
		{name:"deprecStartDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deprecEndDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"purchaseDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"initialValue", type:"float", useNull:true},
		{name:"residualValue", type:"float", useNull:true},
		{name:"depreciationAmount", type:"float", useNull:true},
		{name:"initialDeprecAmount", type:"float", useNull:true}
	],
	validations: [  
		{field: "code", type: 'presence'}, 
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.fi.asset.ds.model.AssetDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
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
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"categoryId", type:"int", useNull:true},
		{name:"categoryId_From",type:"int", useNull:true},
		{name:"categoryId_To",type:"int", useNull:true},
		{name:"category", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productName", type:"string"},
		{name:"withDepreciation", type:"boolean", useNull:true},
		{name:"method", type:"string"},
		{name:"calculation", type:"string"},
		{name:"periodType", type:"string"},
		{name:"periodValue", type:"int", useNull:true},
		{name:"periodValue_From",type:"int", useNull:true},
		{name:"periodValue_To",type:"int", useNull:true},
		{name:"periodPercenatge", type:"int", useNull:true},
		{name:"periodPercenatge_From",type:"int", useNull:true},
		{name:"periodPercenatge_To",type:"int", useNull:true},
		{name:"deprecStartDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deprecStartDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deprecStartDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deprecEndDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deprecEndDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deprecEndDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"purchaseDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"purchaseDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"purchaseDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"initialValue", type:"float", useNull:true},
		{name:"initialValue_From",type:"float", useNull:true},
		{name:"initialValue_To",type:"float", useNull:true},
		{name:"residualValue", type:"float", useNull:true},
		{name:"residualValue_From",type:"float", useNull:true},
		{name:"residualValue_To",type:"float", useNull:true},
		{name:"depreciationAmount", type:"float", useNull:true},
		{name:"depreciationAmount_From",type:"float", useNull:true},
		{name:"depreciationAmount_To",type:"float", useNull:true},
		{name:"initialDeprecAmount", type:"float", useNull:true},
		{name:"initialDeprecAmount_From",type:"float", useNull:true},
		{name:"initialDeprecAmount_To",type:"float", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.fi.asset.ds.param.AssetDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 