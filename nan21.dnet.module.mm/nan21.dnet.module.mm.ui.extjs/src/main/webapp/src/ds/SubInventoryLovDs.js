 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.SubInventoryLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"inventoryId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.SubInventoryLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.SubInventoryLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SubInventoryLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.SubInventoryLovDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.SubInventoryLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.SubInventoryLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 