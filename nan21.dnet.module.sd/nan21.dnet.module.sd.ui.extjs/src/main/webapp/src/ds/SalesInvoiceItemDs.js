 
   	 
Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"invoiceId",type:"int", useNull:true },
		{name:"itemId",type:"int", useNull:true },
		{name:"itemCode",type:"string" },
		{name:"itemName",type:"string" },
		{name:"quantity",type:"float", useNull:true },
		{name:"uomId",type:"int", useNull:true },
		{name:"uomCode",type:"string" },
		{name:"unitPrice",type:"float", useNull:true },
		{name:"netAmount",type:"float", useNull:true }
	],
	validations: [ 
	]
});

Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"invoiceId",type:"int", useNull:true },
		{name:"itemId",type:"int", useNull:true },
		{name:"itemCode",type:"string" },
		{name:"itemName",type:"string" },
		{name:"quantity",type:"float", useNull:true },
		{name:"uomId",type:"int", useNull:true },
		{name:"uomCode",type:"string" },
		{name:"unitPrice",type:"float", useNull:true },
		{name:"netAmount",type:"float", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 