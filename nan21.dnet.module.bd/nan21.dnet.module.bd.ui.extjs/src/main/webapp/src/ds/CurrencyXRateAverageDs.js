 
   	 
Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateAverageDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceId",type:"int", useNull:true },
		{name:"sourceCode",type:"string" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetCode",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"value",type:"float", useNull:true },
		{name:"providerId",type:"int", useNull:true },
		{name:"providerCode",type:"string" }
	],
	validations: [  
		{field: "validFrom", type: 'presence'}, 
		{field: "validTo", type: 'presence'}, 
		{field: "value", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateAverageDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceId",type:"int", useNull:true },
		{name:"sourceCode",type:"string" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetCode",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"value",type:"float", useNull:true },
		{name:"providerId",type:"int", useNull:true },
		{name:"providerCode",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateAverageDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 