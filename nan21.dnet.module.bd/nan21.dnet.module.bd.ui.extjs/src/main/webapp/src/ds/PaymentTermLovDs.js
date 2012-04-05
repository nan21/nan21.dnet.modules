 
   	 
Ext.define("net.nan21.dnet.module.bd.fin.ds.model.PaymentTermLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.fin.ds.model.PaymentTermLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.fin.ds.param.PaymentTermLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 