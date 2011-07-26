 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.LegalEntityOrganizationLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"legalEntity",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.LegalEntityOrganizationLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.LegalEntityOrganizationLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LegalEntityOrganizationLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.LegalEntityOrganizationLovDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.LegalEntityOrganizationLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.LegalEntityOrganizationLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 