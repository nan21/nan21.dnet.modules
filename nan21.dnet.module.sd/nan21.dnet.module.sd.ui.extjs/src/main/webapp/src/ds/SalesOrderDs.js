 
   	 
Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"docNo",type:"string" },
		{name:"docDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"businessObject",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"statusId",type:"int", useNull:true },
		{name:"status",type:"string" },
		{name:"customerId",type:"int", useNull:true },
		{name:"customerCode",type:"string" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currencyCode",type:"string" },
		{name:"priceListId",type:"int", useNull:true },
		{name:"priceListName",type:"string" },
		{name:"paymentMethodId",type:"int", useNull:true },
		{name:"paymentMethod",type:"string" },
		{name:"deliveryMethodId",type:"int", useNull:true },
		{name:"deliveryMethod",type:"string" },
		{name:"supplierId",type:"int", useNull:true },
		{name:"supplierCode",type:"string" },
		{name:"billToId",type:"int", useNull:true },
		{name:"billToCode",type:"string" },
		{name:"billToLocationId",type:"int", useNull:true },
		{name:"billToLocation",type:"string" },
		{name:"shipToId",type:"int", useNull:true },
		{name:"shipToCode",type:"string" },
		{name:"shipToLocationId",type:"int", useNull:true },
		{name:"shipToLocation",type:"string" },
		{name:"totalAmount",type:"float", useNull:true },
		{name:"totalNetAmount",type:"float", useNull:true },
		{name:"totalTaxAmount",type:"float", useNull:true },
		{name:"className",type:"string" }
	],
	validations: [  
		{field: "docNo", type: 'presence'}, 
		{field: "docDate", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 