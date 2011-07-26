 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"hierarchyId",type:"int"}
	,	{name:"organizationId",type:"int"}
	,	{name:"organizationCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyItemLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.OrganizationHierarchyItemLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"OrganizationHierarchyItemLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyItemLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.OrganizationHierarchyItemLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 