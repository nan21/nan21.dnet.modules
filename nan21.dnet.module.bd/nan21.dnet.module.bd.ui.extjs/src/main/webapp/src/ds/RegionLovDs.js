 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.RegionLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.RegionLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 