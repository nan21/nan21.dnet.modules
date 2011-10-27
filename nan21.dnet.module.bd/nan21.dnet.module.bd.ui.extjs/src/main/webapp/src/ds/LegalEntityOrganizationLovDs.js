 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.LegalEntityOrganizationLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"legalEntity",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.LegalEntityOrganizationLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"legalEntity",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.LegalEntityOrganizationLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 