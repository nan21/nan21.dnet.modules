 
   	 
Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceStatusLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"sequenceNo",type:"int", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceStatusLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"sequenceNo",type:"int", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceStatusLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 