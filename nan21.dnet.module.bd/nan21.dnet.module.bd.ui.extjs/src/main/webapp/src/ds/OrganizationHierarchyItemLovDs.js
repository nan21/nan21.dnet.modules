 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"hierarchyId",type:"int", useNull:true },
		{name:"organizationId",type:"int", useNull:true },
		{name:"organizationCode",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyItemLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 