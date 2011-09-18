 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"subInventoryId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.StockLocatorLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"StockLocatorLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorLovDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.StockLocatorLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 