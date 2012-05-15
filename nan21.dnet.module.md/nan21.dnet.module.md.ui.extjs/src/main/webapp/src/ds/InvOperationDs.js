/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDs" ,{
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
		{name:"itemId", type:"int", useNull:true},
		{name:"itemCode", type:"string"},
		{name:"item", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"inventoryId", type:"int", useNull:true},
		{name:"inventory", type:"string"},
		{name:"inventoryName", type:"string"},
		{name:"subInventoryId", type:"int", useNull:true},
		{name:"subInventory", type:"string"},
		{name:"locatorId", type:"int", useNull:true},
		{name:"locator", type:"string"},
		{name:"transactionId", type:"int", useNull:true},
		{name:"transactionLineId", type:"int", useNull:true},
		{name:"direction", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"uomId", type:"int", useNull:true},
		{name:"uom", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvOperationDsFilter" ,{
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
		{name:"itemId", type:"int", useNull:true},
		{name:"itemId_From",type:"int", useNull:true},
		{name:"itemId_To",type:"int", useNull:true},
		{name:"itemCode", type:"string"},
		{name:"item", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"inventoryId", type:"int", useNull:true},
		{name:"inventoryId_From",type:"int", useNull:true},
		{name:"inventoryId_To",type:"int", useNull:true},
		{name:"inventory", type:"string"},
		{name:"inventoryName", type:"string"},
		{name:"subInventoryId", type:"int", useNull:true},
		{name:"subInventoryId_From",type:"int", useNull:true},
		{name:"subInventoryId_To",type:"int", useNull:true},
		{name:"subInventory", type:"string"},
		{name:"locatorId", type:"int", useNull:true},
		{name:"locatorId_From",type:"int", useNull:true},
		{name:"locatorId_To",type:"int", useNull:true},
		{name:"locator", type:"string"},
		{name:"transactionId", type:"int", useNull:true},
		{name:"transactionId_From",type:"int", useNull:true},
		{name:"transactionId_To",type:"int", useNull:true},
		{name:"transactionLineId", type:"int", useNull:true},
		{name:"transactionLineId_From",type:"int", useNull:true},
		{name:"transactionLineId_To",type:"int", useNull:true},
		{name:"direction", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"quantity_From",type:"float", useNull:true},
		{name:"quantity_To",type:"float", useNull:true},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true},
		{name:"uom", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.param.InvOperationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 