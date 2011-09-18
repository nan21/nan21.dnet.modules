 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.ExternalOrganizationLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"external",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.ExternalOrganizationLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.ExternalOrganizationLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ExternalOrganizationLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.ExternalOrganizationLovDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.ExternalOrganizationLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.ExternalOrganizationLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 