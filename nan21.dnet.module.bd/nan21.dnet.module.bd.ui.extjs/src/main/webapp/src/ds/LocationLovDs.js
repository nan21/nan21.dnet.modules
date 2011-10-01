 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetType",type:"string" },
		{name:"asString",type:"string" },
		{name:"active",type:"boolean" }
	],
	validations: [ 
	]
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.LocationLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 