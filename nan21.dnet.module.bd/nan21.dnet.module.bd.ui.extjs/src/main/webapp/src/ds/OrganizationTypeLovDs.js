 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.OrganizationTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.OrganizationTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"OrganizationTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeLovDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.OrganizationTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.OrganizationTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 