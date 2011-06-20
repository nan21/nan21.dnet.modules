 
   	 
Ext.ns("net.nan21.dnet.module.sd.order.ds.model");
	net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"sequenceNo",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds.param");	
	net.nan21.dnet.module.sd.order.ds.param.SalesOrderStatusLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.order.ds");	
	net.nan21.dnet.module.sd.order.ds.SalesOrderStatusLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"SalesOrderStatusLovDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.order.ds.model.SalesOrderStatusLovDs
				,paramFields: net.nan21.dnet.module.sd.order.ds.param.SalesOrderStatusLovDsParam				 
			});
		 	net.nan21.dnet.module.sd.order.ds.SalesOrderStatusLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 