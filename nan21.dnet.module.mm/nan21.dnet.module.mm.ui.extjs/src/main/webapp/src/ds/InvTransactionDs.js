 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.InvTransactionDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"transactionTypeId",type:"int", useNull:true },
		{name:"transactionType",type:"string" },
		{name:"fromInventoryId",type:"int", useNull:true },
		{name:"fromInventory",type:"string" },
		{name:"toInventoryId",type:"int", useNull:true },
		{name:"toInventory",type:"string" },
		{name:"eventDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }
	],
	validations: [ 
	]
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.InvTransactionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 