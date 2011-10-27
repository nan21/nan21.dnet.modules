 
   	 
Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDs" , {
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
		{name:"validAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"value",type:"float", useNull:true },
		{name:"providerId",type:"int", useNull:true },
		{name:"providerCode",type:"string" }
	],
	validations: [  
		{field: "validAt", type: 'presence'}, 
		{field: "value", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.bd.currency.ds.model.CurrencyXRateDsFilter" , {
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
		{name:"validAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"value",type:"float", useNull:true },
		{name:"providerId",type:"int", useNull:true },
		{name:"providerCode",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.currency.ds.param.CurrencyXRateDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 