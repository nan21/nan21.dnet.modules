 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.StockLocatorTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"StockLocatorTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorTypeLovDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.StockLocatorTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 