 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.OrganizationLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.OrganizationLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.OrganizationLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"OrganizationLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.OrganizationLovDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.OrganizationLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.OrganizationLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 