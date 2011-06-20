 
   	 
Ext.ns("net.nan21.dnet.module.sd.order.ds.model");
	net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds.param");	
	net.nan21.dnet.module.sd.order.ds.param.SalesOrderTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds");	
	net.nan21.dnet.module.sd.order.ds.SalesOrderTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesOrderTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.order.ds.model.SalesOrderTypeLovDs
				,paramFields: net.nan21.dnet.module.sd.order.ds.param.SalesOrderTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.sd.order.ds.SalesOrderTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 