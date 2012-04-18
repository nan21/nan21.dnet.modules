 
   	 
Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDs" ,{
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
		{name:"customerId", type:"int", useNull:true},
		{name:"customerCode", type:"string"},
		{name:"customer", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docType", type:"string"},
		{name:"salesOrderId", type:"int", useNull:true},
		{name:"salesOrderUuid", type:"string"},
		{name:"salesOrder", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"transactionType", type:"string"},
		{name:"carrierId", type:"int", useNull:true},
		{name:"carrier", type:"string"},
		{name:"warehouseId", type:"int", useNull:true},
		{name:"warehouse", type:"string"},
		{name:"confirmed", type:"boolean"},
		{name:"posted", type:"boolean"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesDeliveryDsFilter" ,{
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
		{name:"customerId", type:"int", useNull:true},
		{name:"customerId_From",type:"int", useNull:true},
		{name:"customerId_To",type:"int", useNull:true},
		{name:"customerCode", type:"string"},
		{name:"customer", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docTypeId_From",type:"int", useNull:true},
		{name:"docTypeId_To",type:"int", useNull:true},
		{name:"docType", type:"string"},
		{name:"salesOrderId", type:"int", useNull:true},
		{name:"salesOrderId_From",type:"int", useNull:true},
		{name:"salesOrderId_To",type:"int", useNull:true},
		{name:"salesOrderUuid", type:"string"},
		{name:"salesOrder", type:"string"},
		{name:"transactionTypeId", type:"int", useNull:true},
		{name:"transactionTypeId_From",type:"int", useNull:true},
		{name:"transactionTypeId_To",type:"int", useNull:true},
		{name:"transactionType", type:"string"},
		{name:"carrierId", type:"int", useNull:true},
		{name:"carrierId_From",type:"int", useNull:true},
		{name:"carrierId_To",type:"int", useNull:true},
		{name:"carrier", type:"string"},
		{name:"warehouseId", type:"int", useNull:true},
		{name:"warehouseId_From",type:"int", useNull:true},
		{name:"warehouseId_To",type:"int", useNull:true},
		{name:"warehouse", type:"string"},
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
	
Ext.define("net.nan21.dnet.module.sd.order.ds.param.SalesDeliveryDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 