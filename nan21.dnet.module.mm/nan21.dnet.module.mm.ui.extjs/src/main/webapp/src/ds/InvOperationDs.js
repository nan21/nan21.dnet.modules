 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvOperationDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"itemId",type:"int", useNull:true },
		{name:"itemCode",type:"string" },
		{name:"item",type:"string" },
		{name:"inventoryId",type:"int", useNull:true },
		{name:"inventory",type:"string" },
		{name:"inventoryName",type:"string" },
		{name:"subInventoryId",type:"int", useNull:true },
		{name:"subInventory",type:"string" },
		{name:"locatorId",type:"int", useNull:true },
		{name:"locator",type:"string" },
		{name:"transactionId",type:"int", useNull:true },
		{name:"transactionLineId",type:"int", useNull:true },
		{name:"direction",type:"string" },
		{name:"quantity",type:"float", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvOperationDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"itemId",type:"int", useNull:true },
		{name:"itemCode",type:"string" },
		{name:"item",type:"string" },
		{name:"inventoryId",type:"int", useNull:true },
		{name:"inventory",type:"string" },
		{name:"inventoryName",type:"string" },
		{name:"subInventoryId",type:"int", useNull:true },
		{name:"subInventory",type:"string" },
		{name:"locatorId",type:"int", useNull:true },
		{name:"locator",type:"string" },
		{name:"transactionId",type:"int", useNull:true },
		{name:"transactionLineId",type:"int", useNull:true },
		{name:"direction",type:"string" },
		{name:"quantity",type:"float", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.InvOperationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 