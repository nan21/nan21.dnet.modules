/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"hierarchyId", type:"int", useNull:true},
		{name:"orgId", type:"int", useNull:true},
		{name:"org", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"hierarchyId", type:"int", useNull:true},
		{name:"hierarchyId_From",type:"int", useNull:true},
		{name:"hierarchyId_To",type:"int", useNull:true},
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"org", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyItemLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 