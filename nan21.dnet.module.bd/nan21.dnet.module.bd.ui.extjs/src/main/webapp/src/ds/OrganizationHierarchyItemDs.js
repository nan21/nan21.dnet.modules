 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"hierarchyId", type:"int", useNull:true},
		{name:"hierarchy", type:"string"},
		{name:"organizationId", type:"int", useNull:true},
		{name:"organizationCode", type:"string"},
		{name:"parentId", type:"int", useNull:true},
		{name:"parentCode", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"hierarchyId", type:"int", useNull:true},
		{name:"hierarchyId_From",type:"int", useNull:true},
		{name:"hierarchyId_To",type:"int", useNull:true},
		{name:"hierarchy", type:"string"},
		{name:"organizationId", type:"int", useNull:true},
		{name:"organizationId_From",type:"int", useNull:true},
		{name:"organizationId_To",type:"int", useNull:true},
		{name:"organizationCode", type:"string"},
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
 