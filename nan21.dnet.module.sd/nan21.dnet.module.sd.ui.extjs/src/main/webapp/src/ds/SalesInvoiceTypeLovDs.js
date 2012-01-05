 
   	 
Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 