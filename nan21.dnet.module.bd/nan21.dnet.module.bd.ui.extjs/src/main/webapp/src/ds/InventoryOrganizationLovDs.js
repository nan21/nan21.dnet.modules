 
   	 
Ext.ns("net.nan21.dnet.module.bd.org.ds.model");
	net.nan21.dnet.module.bd.org.ds.model.InventoryOrganizationLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"inventory",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds.param");	
	net.nan21.dnet.module.bd.org.ds.param.InventoryOrganizationLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.org.ds");	
	net.nan21.dnet.module.bd.org.ds.InventoryOrganizationLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"InventoryOrganizationLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.org.ds.model.InventoryOrganizationLovDs
				,paramFields: net.nan21.dnet.module.bd.org.ds.param.InventoryOrganizationLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.org.ds.InventoryOrganizationLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 