 
   	 
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 