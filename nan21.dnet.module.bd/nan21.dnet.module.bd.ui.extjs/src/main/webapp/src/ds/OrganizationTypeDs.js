 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"virtualEntity",type:"boolean"}
	,	{name:"legalEntity",type:"boolean"}
	,	{name:"accountingEnabled",type:"boolean"}
	,	{name:"inventory",type:"boolean"}
	,	{name:"external",type:"boolean"}
	,	{name:"carrier",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.OrganizationTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.OrganizationTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"OrganizationTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.OrganizationTypeDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.OrganizationTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 