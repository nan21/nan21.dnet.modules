 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"hierarchyId",type:"int"}
	,	{name:"hierarchy",type:"string"}
	,	{name:"organizationId",type:"int"}
	,	{name:"organizationCode",type:"string"}
	,	{name:"parentId",type:"int"}
	,	{name:"parentCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyItemDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.OrganizationHierarchyItemDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"OrganizationHierarchyItemDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyItemDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.OrganizationHierarchyItemDs.superclass.constructor.call(this, config);
		}	 
	});  
 