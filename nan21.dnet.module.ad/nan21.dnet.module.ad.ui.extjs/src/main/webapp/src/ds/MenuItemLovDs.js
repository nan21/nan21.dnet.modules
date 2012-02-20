 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MenuItemLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"title", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MenuItemLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"title", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.MenuItemLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 