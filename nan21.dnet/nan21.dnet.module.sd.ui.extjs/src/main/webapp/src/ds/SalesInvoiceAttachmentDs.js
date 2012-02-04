 
   	 
Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceAttachmentDs" ,{
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
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"category", type:"string"},
		{name:"invoiceId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"location", type:"string"},
		{name:"notes", type:"string"},
		{name:"url", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceAttachmentDsFilter" ,{
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
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"category", type:"string"},
		{name:"invoiceId", type:"int", useNull:true},
		{name:"invoiceId_From",type:"int", useNull:true},
		{name:"invoiceId_To",type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"location", type:"string"},
		{name:"notes", type:"string"},
		{name:"url", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceAttachmentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 