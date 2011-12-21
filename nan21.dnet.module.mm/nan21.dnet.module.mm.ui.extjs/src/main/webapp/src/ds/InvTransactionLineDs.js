 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionLineDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"transactionId",type:"int", useNull:true },
		{name:"fromInventoryId",type:"int", useNull:true },
		{name:"toInventoryId",type:"int", useNull:true },
		{name:"itemId",type:"int", useNull:true },
		{name:"itemCode",type:"string" },
		{name:"item",type:"string" },
		{name:"fromSubInventoryId",type:"int", useNull:true },
		{name:"fromSubInventory",type:"string" },
		{name:"fromLocatorId",type:"int", useNull:true },
		{name:"fromLocator",type:"string" },
		{name:"toSubInventoryId",type:"int", useNull:true },
		{name:"toSubInventory",type:"string" },
		{name:"toLocatorId",type:"int", useNull:true },
		{name:"toLocator",type:"string" },
		{name:"quantity",type:"float", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionLineDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"transactionId",type:"int", useNull:true },
		{name:"fromInventoryId",type:"int", useNull:true },
		{name:"toInventoryId",type:"int", useNull:true },
		{name:"itemId",type:"int", useNull:true },
		{name:"itemCode",type:"string" },
		{name:"item",type:"string" },
		{name:"fromSubInventoryId",type:"int", useNull:true },
		{name:"fromSubInventory",type:"string" },
		{name:"fromLocatorId",type:"int", useNull:true },
		{name:"fromLocator",type:"string" },
		{name:"toSubInventoryId",type:"int", useNull:true },
		{name:"toSubInventory",type:"string" },
		{name:"toLocatorId",type:"int", useNull:true },
		{name:"toLocator",type:"string" },
		{name:"quantity",type:"float", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionLineDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 