 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetType", type:"string"},
		{name:"asString", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetId_From",type:"int", useNull:true},
		{name:"targetId_To",type:"int", useNull:true},
		{name:"targetType", type:"string"},
		{name:"asString", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.LocationLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 