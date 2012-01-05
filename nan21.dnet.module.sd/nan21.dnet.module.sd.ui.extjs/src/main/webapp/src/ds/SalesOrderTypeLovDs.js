 
   	 
Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.order.ds.param.SalesOrderTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 