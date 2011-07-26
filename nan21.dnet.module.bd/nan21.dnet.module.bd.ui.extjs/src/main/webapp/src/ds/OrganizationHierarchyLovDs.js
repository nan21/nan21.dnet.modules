 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"startDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.OrganizationHierarchyLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"OrganizationHierarchyLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyLovDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.OrganizationHierarchyLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 