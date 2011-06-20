 
   	 
Ext.ns("net.nan21.dnet.module.sd.order.ds.model");
	net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"docNo",type:"string"}
	,	{name:"docDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"statusId",type:"int"}
	,	{name:"status",type:"string"}
	,	{name:"customerId",type:"int"}
	,	{name:"customerCode",type:"string"}
	,	{name:"currencyId",type:"int"}
	,	{name:"currencyCode",type:"string"}
	,	{name:"priceListId",type:"int"}
	,	{name:"priceListName",type:"string"}
	,	{name:"paymentMethodId",type:"int"}
	,	{name:"paymentMethod",type:"string"}
	,	{name:"deliveryMethodId",type:"int"}
	,	{name:"deliveryMethod",type:"string"}
	,	{name:"supplierId",type:"int"}
	,	{name:"supplierCode",type:"string"}
	,	{name:"billToId",type:"int"}
	,	{name:"billToCode",type:"string"}
	,	{name:"billToLocationId",type:"int"}
	,	{name:"billToLocation",type:"string"}
	,	{name:"shipToId",type:"int"}
	,	{name:"shipToCode",type:"string"}
	,	{name:"shipToLocationId",type:"int"}
	,	{name:"shipToLocation",type:"string"}
	,	{name:"totalAmount",type:"float"}
	,	{name:"totalNetAmount",type:"float"}
	,	{name:"totalTaxAmount",type:"float"}
	,	{name:"className",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds.param");	
	net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds");	
	net.nan21.dnet.module.sd.order.ds.SalesOrderDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesOrderDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs
				,paramFields: net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam				 
			});
		 	net.nan21.dnet.module.sd.order.ds.SalesOrderDs.superclass.constructor.call(this, config);
		}	 
	});  
 