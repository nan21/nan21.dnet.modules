 
   	 
Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"salesOrderId", type:"int", useNull:true},
		{name:"productId", type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productName", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomCode", type:"string"},
		{name:"qtyOrdered", type:"float", useNull:true},
		{name:"netUnitPrice", type:"float", useNull:true},
		{name:"netAmount", type:"float", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"salesOrderId", type:"int", useNull:true},
		{name:"salesOrderId_From",type:"int", useNull:true},
		{name:"salesOrderId_To",type:"int", useNull:true},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"productName", type:"string"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true},
		{name:"uomCode", type:"string"},
		{name:"qtyOrdered", type:"float", useNull:true},
		{name:"qtyOrdered_From",type:"float", useNull:true},
		{name:"qtyOrdered_To",type:"float", useNull:true},
		{name:"netUnitPrice", type:"float", useNull:true},
		{name:"netUnitPrice_From",type:"float", useNull:true},
		{name:"netUnitPrice_To",type:"float", useNull:true},
		{name:"netAmount", type:"float", useNull:true},
		{name:"netAmount_From",type:"float", useNull:true},
		{name:"netAmount_To",type:"float", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.order.ds.param.SalesOrderItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 