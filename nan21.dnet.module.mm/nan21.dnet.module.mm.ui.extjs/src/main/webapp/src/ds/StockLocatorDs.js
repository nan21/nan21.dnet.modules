 
   	 
Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"subInventoryId", type:"int", useNull:true},
		{name:"subInventory", type:"string"},
		{name:"locatorTypeId", type:"int", useNull:true},
		{name:"locatorType", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"subInventoryId", type:"int", useNull:true},
		{name:"subInventoryId_From",type:"int", useNull:true},
		{name:"subInventoryId_To",type:"int", useNull:true},
		{name:"subInventory", type:"string"},
		{name:"locatorTypeId", type:"int", useNull:true},
		{name:"locatorTypeId_From",type:"int", useNull:true},
		{name:"locatorTypeId_To",type:"int", useNull:true},
		{name:"locatorType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 