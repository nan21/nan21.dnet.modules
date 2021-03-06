/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDs" ,{
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
		{name:"sourceId", type:"int", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"validAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"value", type:"float", useNull:true},
		{name:"providerId", type:"int", useNull:true},
		{name:"providerCode", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDsFilter" ,{
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
		{name:"sourceId", type:"int", useNull:true},
		{name:"sourceId_From",type:"int", useNull:true},
		{name:"sourceId_To",type:"int", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetId_From",type:"int", useNull:true},
		{name:"targetId_To",type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"validAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"value", type:"float", useNull:true},
		{name:"value_From",type:"float", useNull:true},
		{name:"value_To",type:"float", useNull:true},
		{name:"providerId", type:"int", useNull:true},
		{name:"providerId_From",type:"int", useNull:true},
		{name:"providerId_To",type:"int", useNull:true},
		{name:"providerCode", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 