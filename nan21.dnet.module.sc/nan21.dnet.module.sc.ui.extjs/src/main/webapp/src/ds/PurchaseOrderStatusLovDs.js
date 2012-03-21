 
   	 
Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderStatusLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"sequenceNo", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderStatusLovDsFilter" ,{
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
	
Ext.define("net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderStatusLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 