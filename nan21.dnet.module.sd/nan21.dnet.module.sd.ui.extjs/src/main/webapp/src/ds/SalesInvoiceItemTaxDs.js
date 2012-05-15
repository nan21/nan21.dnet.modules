/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemTaxDs" ,{
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
		{name:"salesInvoiceItemId", type:"int", useNull:true},
		{name:"taxId", type:"int", useNull:true},
		{name:"tax", type:"string"},
		{name:"baseAmount", type:"float", useNull:true},
		{name:"taxAmount", type:"float", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemTaxDsFilter" ,{
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
		{name:"salesInvoiceItemId", type:"int", useNull:true},
		{name:"salesInvoiceItemId_From",type:"int", useNull:true},
		{name:"salesInvoiceItemId_To",type:"int", useNull:true},
		{name:"taxId", type:"int", useNull:true},
		{name:"taxId_From",type:"int", useNull:true},
		{name:"taxId_To",type:"int", useNull:true},
		{name:"tax", type:"string"},
		{name:"baseAmount", type:"float", useNull:true},
		{name:"baseAmount_From",type:"float", useNull:true},
		{name:"baseAmount_To",type:"float", useNull:true},
		{name:"taxAmount", type:"float", useNull:true},
		{name:"taxAmount_From",type:"float", useNull:true},
		{name:"taxAmount_To",type:"float", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceItemTaxDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 