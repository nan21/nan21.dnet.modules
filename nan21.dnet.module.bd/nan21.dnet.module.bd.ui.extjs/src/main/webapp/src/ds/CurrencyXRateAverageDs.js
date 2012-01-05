 
   	 
Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateAverageDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"sourceId", type:"int", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"value", type:"float", useNull:true},
		{name:"providerId", type:"int", useNull:true},
		{name:"providerCode", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateAverageDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"sourceId", type:"int", useNull:true},
		{name:"sourceId_From",type:"int", useNull:true},
		{name:"sourceId_To",type:"int", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetId_From",type:"int", useNull:true},
		{name:"targetId_To",type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"value", type:"float", useNull:true},
		{name:"value_From",type:"float", useNull:true},
		{name:"value_To",type:"float", useNull:true},
		{name:"providerId", type:"int", useNull:true},
		{name:"providerId_From",type:"int", useNull:true},
		{name:"providerId_To",type:"int", useNull:true},
		{name:"providerCode", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateAverageDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 