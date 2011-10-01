 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.OrganizationTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 