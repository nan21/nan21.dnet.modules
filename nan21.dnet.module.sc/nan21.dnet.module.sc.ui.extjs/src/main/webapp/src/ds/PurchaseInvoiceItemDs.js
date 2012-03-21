 
   	 
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDs" ,{
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
		{name:"invoiceId", type:"int", useNull:true},
		{name:"itemId", type:"int", useNull:true},
		{name:"itemCode", type:"string"},
		{name:"itemName", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomCode", type:"string"},
		{name:"unitPrice", type:"float", useNull:true},
		{name:"netAmount", type:"float", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDsFilter" ,{
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
		{name:"invoiceId", type:"int", useNull:true},
		{name:"invoiceId_From",type:"int", useNull:true},
		{name:"invoiceId_To",type:"int", useNull:true},
		{name:"itemId", type:"int", useNull:true},
		{name:"itemId_From",type:"int", useNull:true},
		{name:"itemId_To",type:"int", useNull:true},
		{name:"itemCode", type:"string"},
		{name:"itemName", type:"string"},
		{name:"quantity", type:"float", useNull:true},
		{name:"quantity_From",type:"float", useNull:true},
		{name:"quantity_To",type:"float", useNull:true},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true},
		{name:"uomCode", type:"string"},
		{name:"unitPrice", type:"float", useNull:true},
		{name:"unitPrice_From",type:"float", useNull:true},
		{name:"unitPrice_To",type:"float", useNull:true},
		{name:"netAmount", type:"float", useNull:true},
		{name:"netAmount_From",type:"float", useNull:true},
		{name:"netAmount_To",type:"float", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 