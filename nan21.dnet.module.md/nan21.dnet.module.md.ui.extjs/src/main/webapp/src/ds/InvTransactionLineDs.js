/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionLineDs" ,{
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
		{name:"transactionId", type:"int", useNull:true},
		{name:"fromInventoryId", type:"int", useNull:true},
		{name:"toInventoryId", type:"int", useNull:true},
		{name:"itemId", type:"int", useNull:true},
		{name:"itemCode", type:"string"},
		{name:"item", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uom", type:"string"},
		{name:"fromSubInventoryId", type:"int", useNull:true},
		{name:"fromSubInventory", type:"string"},
		{name:"fromLocatorId", type:"int", useNull:true},
		{name:"fromLocator", type:"string"},
		{name:"toSubInventoryId", type:"int", useNull:true},
		{name:"toSubInventory", type:"string"},
		{name:"toLocatorId", type:"int", useNull:true},
		{name:"toLocator", type:"string"},
		{name:"quantity", type:"float", useNull:true}
	],
	validations: [  
		{field: "itemCode", type: 'presence'}, 
		{field: "quantity", type: 'presence'}, 
		{field: "uom", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.model.InvTransactionLineDsFilter" ,{
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
		{name:"transactionId", type:"int", useNull:true},
		{name:"transactionId_From",type:"int", useNull:true},
		{name:"transactionId_To",type:"int", useNull:true},
		{name:"fromInventoryId", type:"int", useNull:true},
		{name:"fromInventoryId_From",type:"int", useNull:true},
		{name:"fromInventoryId_To",type:"int", useNull:true},
		{name:"toInventoryId", type:"int", useNull:true},
		{name:"toInventoryId_From",type:"int", useNull:true},
		{name:"toInventoryId_To",type:"int", useNull:true},
		{name:"itemId", type:"int", useNull:true},
		{name:"itemId_From",type:"int", useNull:true},
		{name:"itemId_To",type:"int", useNull:true},
		{name:"itemCode", type:"string"},
		{name:"item", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true},
		{name:"uom", type:"string"},
		{name:"fromSubInventoryId", type:"int", useNull:true},
		{name:"fromSubInventoryId_From",type:"int", useNull:true},
		{name:"fromSubInventoryId_To",type:"int", useNull:true},
		{name:"fromSubInventory", type:"string"},
		{name:"fromLocatorId", type:"int", useNull:true},
		{name:"fromLocatorId_From",type:"int", useNull:true},
		{name:"fromLocatorId_To",type:"int", useNull:true},
		{name:"fromLocator", type:"string"},
		{name:"toSubInventoryId", type:"int", useNull:true},
		{name:"toSubInventoryId_From",type:"int", useNull:true},
		{name:"toSubInventoryId_To",type:"int", useNull:true},
		{name:"toSubInventory", type:"string"},
		{name:"toLocatorId", type:"int", useNull:true},
		{name:"toLocatorId_From",type:"int", useNull:true},
		{name:"toLocatorId_To",type:"int", useNull:true},
		{name:"toLocator", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"quantity_From",type:"float", useNull:true},
		{name:"quantity_To",type:"float", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.tx.inventory.ds.param.InvTransactionLineDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 