 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.RolesOfUserLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.RolesOfUserLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.RolesOfUserLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 