 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceTypeId",type:"int", useNull:true },
		{name:"sourceType",type:"string" },
		{name:"actionId",type:"int", useNull:true },
		{name:"action",type:"string" },
		{name:"hasFromInventory",type:"boolean" },
		{name:"hasToInventory",type:"boolean" }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionTypeDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceTypeId",type:"int", useNull:true },
		{name:"sourceType",type:"string" },
		{name:"actionId",type:"int", useNull:true },
		{name:"action",type:"string" },
		{name:"hasFromInventory",type:"boolean", useNull:true },
		{name:"hasToInventory",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionTypeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 