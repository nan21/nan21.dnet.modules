 
   	 
Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"sequenceNo",type:"int", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"sequenceNo",type:"int", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.order.ds.param.SalesOrderStatusLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 