 
   	 
Ext.define("net.nan21.dnet.module.bd.tx.ds.model.PaymentMethodInLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"type", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.tx.ds.model.PaymentMethodInLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"type", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.tx.ds.param.PaymentMethodInLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 