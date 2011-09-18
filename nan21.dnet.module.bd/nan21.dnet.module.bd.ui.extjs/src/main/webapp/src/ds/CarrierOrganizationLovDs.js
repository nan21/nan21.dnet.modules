 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.CarrierOrganizationLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"carrier",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.CarrierOrganizationLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.CarrierOrganizationLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CarrierOrganizationLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.CarrierOrganizationLovDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.CarrierOrganizationLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.CarrierOrganizationLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 