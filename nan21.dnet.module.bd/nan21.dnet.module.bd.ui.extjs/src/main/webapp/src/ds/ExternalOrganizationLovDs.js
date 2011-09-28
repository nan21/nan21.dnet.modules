 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.ExternalOrganizationLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"code",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }, 		
		{name:"external",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.ExternalOrganizationLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 