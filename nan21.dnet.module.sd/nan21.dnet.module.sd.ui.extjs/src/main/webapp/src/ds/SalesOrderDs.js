 
   	 
Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs" ,{
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
		{name:"code", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplier", type:"string"},
		{name:"customerId", type:"int", useNull:true},
		{name:"customerUuid", type:"string"},
		{name:"customerCode", type:"string"},
		{name:"customer", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"priceListId", type:"int", useNull:true},
		{name:"priceList", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"deliveryMethodId", type:"int", useNull:true},
		{name:"deliveryMethod", type:"string"},
		{name:"billToId", type:"int", useNull:true},
		{name:"billToUuid", type:"string"},
		{name:"billToCode", type:"string"},
		{name:"billTo", type:"string"},
		{name:"billToLocationId", type:"int", useNull:true},
		{name:"billToLocation", type:"string"},
		{name:"shipToId", type:"int", useNull:true},
		{name:"shipToUuid", type:"string"},
		{name:"shipToCode", type:"string"},
		{name:"shipTo", type:"string"},
		{name:"shipToLocationId", type:"int", useNull:true},
		{name:"shipToLocation", type:"string"},
		{name:"totalAmount", type:"float", useNull:true},
		{name:"totalNetAmount", type:"float", useNull:true},
		{name:"totalTaxAmount", type:"float", useNull:true},
		{name:"confirmed", type:"boolean"},
		{name:"invoiced", type:"boolean"},
		{name:"delivered", type:"boolean"},
		{name:"className", type:"string"},
		{name:"businessObject", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsFilter" ,{
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
		{name:"code", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"supplierId", type:"int", useNull:true},
		{name:"supplierId_From",type:"int", useNull:true},
		{name:"supplierId_To",type:"int", useNull:true},
		{name:"supplier", type:"string"},
		{name:"customerId", type:"int", useNull:true},
		{name:"customerId_From",type:"int", useNull:true},
		{name:"customerId_To",type:"int", useNull:true},
		{name:"customerUuid", type:"string"},
		{name:"customerCode", type:"string"},
		{name:"customer", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"priceListId", type:"int", useNull:true},
		{name:"priceListId_From",type:"int", useNull:true},
		{name:"priceListId_To",type:"int", useNull:true},
		{name:"priceList", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethodId_From",type:"int", useNull:true},
		{name:"paymentMethodId_To",type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"deliveryMethodId", type:"int", useNull:true},
		{name:"deliveryMethodId_From",type:"int", useNull:true},
		{name:"deliveryMethodId_To",type:"int", useNull:true},
		{name:"deliveryMethod", type:"string"},
		{name:"billToId", type:"int", useNull:true},
		{name:"billToId_From",type:"int", useNull:true},
		{name:"billToId_To",type:"int", useNull:true},
		{name:"billToUuid", type:"string"},
		{name:"billToCode", type:"string"},
		{name:"billTo", type:"string"},
		{name:"billToLocationId", type:"int", useNull:true},
		{name:"billToLocationId_From",type:"int", useNull:true},
		{name:"billToLocationId_To",type:"int", useNull:true},
		{name:"billToLocation", type:"string"},
		{name:"shipToId", type:"int", useNull:true},
		{name:"shipToId_From",type:"int", useNull:true},
		{name:"shipToId_To",type:"int", useNull:true},
		{name:"shipToUuid", type:"string"},
		{name:"shipToCode", type:"string"},
		{name:"shipTo", type:"string"},
		{name:"shipToLocationId", type:"int", useNull:true},
		{name:"shipToLocationId_From",type:"int", useNull:true},
		{name:"shipToLocationId_To",type:"int", useNull:true},
		{name:"shipToLocation", type:"string"},
		{name:"totalAmount", type:"float", useNull:true},
		{name:"totalAmount_From",type:"float", useNull:true},
		{name:"totalAmount_To",type:"float", useNull:true},
		{name:"totalNetAmount", type:"float", useNull:true},
		{name:"totalNetAmount_From",type:"float", useNull:true},
		{name:"totalNetAmount_To",type:"float", useNull:true},
		{name:"totalTaxAmount", type:"float", useNull:true},
		{name:"totalTaxAmount_From",type:"float", useNull:true},
		{name:"totalTaxAmount_To",type:"float", useNull:true},
		{name:"confirmed", type:"boolean", useNull:true},
		{name:"invoiced", type:"boolean", useNull:true},
		{name:"delivered", type:"boolean", useNull:true},
		{name:"className", type:"string"},
		{name:"businessObject", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 