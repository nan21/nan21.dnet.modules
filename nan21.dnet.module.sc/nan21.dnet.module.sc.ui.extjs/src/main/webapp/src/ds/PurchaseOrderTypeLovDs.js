 
   	 
Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 