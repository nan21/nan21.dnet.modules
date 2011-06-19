 
   	 
Ext.ns("net.nan21.dnet.module.ad.org.ds.model");
	net.nan21.dnet.module.ad.org.ds.model.OrganizationHierarchyDs = [
	{name:"name",type:"string"}
	,	{name:"startDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"active",type:"boolean"}
	,	{name:"notes",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.org.ds.param");	
	net.nan21.dnet.module.ad.org.ds.param.OrganizationHierarchyDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.org.ds");	
	net.nan21.dnet.module.ad.org.ds.OrganizationHierarchyDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"OrganizationHierarchyDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.org.ds.model.OrganizationHierarchyDs
				,paramFields: net.nan21.dnet.module.ad.org.ds.param.OrganizationHierarchyDsParam				 
			});
		 	net.nan21.dnet.module.ad.org.ds.OrganizationHierarchyDs.superclass.constructor.call(this, config);
		}	 
	});  
 