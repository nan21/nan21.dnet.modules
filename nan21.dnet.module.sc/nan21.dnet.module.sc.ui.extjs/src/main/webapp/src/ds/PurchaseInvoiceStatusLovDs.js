 
   	 
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceStatusLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"sequenceNo", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceStatusLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceStatusLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 