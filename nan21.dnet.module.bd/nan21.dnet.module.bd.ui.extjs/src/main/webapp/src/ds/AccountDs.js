 
   	 
Ext.define("net.nan21.dnet.module.bd.acc.ds.model.AccountDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"accSchemaId",type:"int", useNull:true },
		{name:"accSchema",type:"string" },
		{name:"accGroupId",type:"int", useNull:true },
		{name:"accGroup",type:"string" },
		{name:"sign",type:"string" },
		{name:"summary",type:"boolean" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "code", type: 'presence'}, 
		{field: "sign", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.bd.acc.ds.model.AccountDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"accSchemaId",type:"int", useNull:true },
		{name:"accSchema",type:"string" },
		{name:"accGroupId",type:"int", useNull:true },
		{name:"accGroup",type:"string" },
		{name:"sign",type:"string" },
		{name:"summary",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.acc.ds.param.AccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 