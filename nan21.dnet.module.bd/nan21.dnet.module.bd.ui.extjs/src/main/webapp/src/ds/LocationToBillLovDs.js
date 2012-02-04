 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationToBillLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"targetUuid", type:"string"},
		{name:"targetType", type:"string"},
		{name:"asString", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationToBillLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"targetUuid", type:"string"},
		{name:"targetType", type:"string"},
		{name:"asString", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.LocationToBillLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 