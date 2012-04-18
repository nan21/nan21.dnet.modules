 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransferDs" ,{
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
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docType", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"transactionType", type:"string"},
		{name:"hasFromInventory", type:"boolean"},
		{name:"hasToInventory", type:"boolean"},
		{name:"fromInventoryId", type:"int", useNull:true},
		{name:"fromInventory", type:"string"},
		{name:"toInventoryId", type:"int", useNull:true},
		{name:"toInventory", type:"string"},
		{name:"confirmed", type:"boolean"},
		{name:"posted", type:"boolean"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransferDsFilter" ,{
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
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docTypeId_From",type:"int", useNull:true},
		{name:"docTypeId_To",type:"int", useNull:true},
		{name:"docType", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"transactionTypeId_From",type:"int", useNull:true},
		{name:"transactionTypeId_To",type:"int", useNull:true},
		{name:"transactionType", type:"string"},
		{name:"hasFromInventory", type:"boolean", useNull:true},
		{name:"hasToInventory", type:"boolean", useNull:true},
		{name:"fromInventoryId", type:"int", useNull:true},
		{name:"fromInventoryId_From",type:"int", useNull:true},
		{name:"fromInventoryId_To",type:"int", useNull:true},
		{name:"fromInventory", type:"string"},
		{name:"toInventoryId", type:"int", useNull:true},
		{name:"toInventoryId_From",type:"int", useNull:true},
		{name:"toInventoryId_To",type:"int", useNull:true},
		{name:"toInventory", type:"string"},
		{name:"confirmed", type:"boolean", useNull:true},
		{name:"posted", type:"boolean", useNull:true},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.InvTransferDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 