 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.WarehouseOrganizationLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"warehouse", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.WarehouseOrganizationLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"warehouse", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.WarehouseOrganizationLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 