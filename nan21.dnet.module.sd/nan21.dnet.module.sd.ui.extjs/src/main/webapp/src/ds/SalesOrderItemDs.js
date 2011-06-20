 
   	 
Ext.ns("net.nan21.dnet.module.sd.order.ds.model");
	net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"salesOrderId",type:"int"}
	,	{name:"productId",type:"int"}
	,	{name:"productCode",type:"string"}
	,	{name:"productName",type:"string"}
	,	{name:"uomId",type:"int"}
	,	{name:"uomCode",type:"string"}
	,	{name:"qtyOrdered",type:"float"}
	,	{name:"netUnitPrice",type:"float"}
	,	{name:"netAmount",type:"float"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds.param");	
	net.nan21.dnet.module.sd.order.ds.param.SalesOrderItemDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds");	
	net.nan21.dnet.module.sd.order.ds.SalesOrderItemDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesOrderItemDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.order.ds.model.SalesOrderItemDs
				,paramFields: net.nan21.dnet.module.sd.order.ds.param.SalesOrderItemDsParam				 
			});
		 	net.nan21.dnet.module.sd.order.ds.SalesOrderItemDs.superclass.constructor.call(this, config);
		}	 
	});  
 