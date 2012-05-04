 
   	 
Ext.define("net.nan21.dnet.module.bd.tx.ds.model.PaymentMethodOutLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"type", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.tx.ds.model.PaymentMethodOutLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"type", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.tx.ds.param.PaymentMethodOutLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 