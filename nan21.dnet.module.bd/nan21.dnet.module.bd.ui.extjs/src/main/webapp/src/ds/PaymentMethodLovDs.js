 
   	 
Ext.define("net.nan21.dnet.module.bd.tx.ds.model.PaymentMethodLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.tx.ds.model.PaymentMethodLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.tx.ds.param.PaymentMethodLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 