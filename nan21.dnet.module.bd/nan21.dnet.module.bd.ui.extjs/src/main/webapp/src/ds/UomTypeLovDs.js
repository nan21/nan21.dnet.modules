 
   	 
Ext.ns("net.nan21.dnet.module.bd.uom.ds.model");
	net.nan21.dnet.module.bd.uom.ds.model.UomTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds.param");	
	net.nan21.dnet.module.bd.uom.ds.param.UomTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds");	
	net.nan21.dnet.module.bd.uom.ds.UomTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UomTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.uom.ds.model.UomTypeLovDs
				,paramFields: net.nan21.dnet.module.bd.uom.ds.param.UomTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.uom.ds.UomTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 