 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvBalanceDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"subInventoryId",type:"int", useNull:true },
		{name:"subInventory",type:"string" },
		{name:"locatorId",type:"int", useNull:true },
		{name:"locator",type:"string" },
		{name:"itemId",type:"int", useNull:true },
		{name:"item",type:"string" },
		{name:"itemName",type:"string" },
		{name:"quantity",type:"float", useNull:true },
		{name:"uomId",type:"int", useNull:true },
		{name:"uom",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.InvBalanceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 