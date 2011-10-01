 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.RoleLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.RoleLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 