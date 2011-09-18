 
   	 
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.model");
	net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorDs = [
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
	,	{name:"subInventoryId",type:"int"}
	,	{name:"subInventory",type:"string"}
	,	{name:"locatorTypeId",type:"int"}
	,	{name:"locatorType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds.param");	
	net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.inventory.ds");	
	net.nan21.dnet.module.mm.inventory.ds.StockLocatorDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"StockLocatorDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.inventory.ds.model.StockLocatorDs
				,paramFields: net.nan21.dnet.module.mm.inventory.ds.param.StockLocatorDsParam				 
			});
		 	net.nan21.dnet.module.mm.inventory.ds.StockLocatorDs.superclass.constructor.call(this, config);
		}	 
	});  
 