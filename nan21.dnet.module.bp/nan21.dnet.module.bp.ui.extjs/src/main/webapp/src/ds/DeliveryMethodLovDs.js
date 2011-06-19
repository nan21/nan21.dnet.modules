 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds.param");	
	net.nan21.dnet.module.bp.base.ds.param.DeliveryMethodLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.DeliveryMethodLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"DeliveryMethodLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodLovDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.DeliveryMethodLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.DeliveryMethodLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 