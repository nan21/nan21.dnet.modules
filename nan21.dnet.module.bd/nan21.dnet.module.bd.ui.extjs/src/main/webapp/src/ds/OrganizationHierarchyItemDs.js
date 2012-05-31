/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"hierarchyId", type:"int", useNull:true},
		{name:"hierarchy", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"parentId", type:"int", useNull:true},
		{name:"parentCode", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"hierarchyId", type:"int", useNull:true},
		{name:"hierarchyId_From",type:"int", useNull:true},
		{name:"hierarchyId_To",type:"int", useNull:true},
		{name:"hierarchy", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"parentId", type:"int", useNull:true},
		{name:"parentId_From",type:"int", useNull:true},
		{name:"parentId_To",type:"int", useNull:true},
		{name:"parentCode", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 