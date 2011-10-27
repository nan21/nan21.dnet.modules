 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.CarrierOrganizationLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"carrier",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.CarrierOrganizationLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"carrier",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.CarrierOrganizationLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 