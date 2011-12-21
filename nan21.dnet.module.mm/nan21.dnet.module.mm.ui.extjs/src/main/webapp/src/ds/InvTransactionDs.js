 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"transactionTypeId",type:"int", useNull:true },
		{name:"transactionType",type:"string" },
		{name:"hasFromInventory",type:"boolean" },
		{name:"hasToInventory",type:"boolean" },
		{name:"fromInventoryId",type:"int", useNull:true },
		{name:"fromInventory",type:"string" },
		{name:"toInventoryId",type:"int", useNull:true },
		{name:"toInventory",type:"string" },
		{name:"eventDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT }
	]
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"transactionTypeId",type:"int", useNull:true },
		{name:"transactionType",type:"string" },
		{name:"hasFromInventory",type:"boolean", useNull:true },
		{name:"hasToInventory",type:"boolean", useNull:true },
		{name:"fromInventoryId",type:"int", useNull:true },
		{name:"fromInventory",type:"string" },
		{name:"toInventoryId",type:"int", useNull:true },
		{name:"toInventory",type:"string" },
		{name:"eventDate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 