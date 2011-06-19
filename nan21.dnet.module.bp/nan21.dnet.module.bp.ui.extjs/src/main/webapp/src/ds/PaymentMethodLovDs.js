 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.PaymentMethodLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds.param");	
	net.nan21.dnet.module.bp.base.ds.param.PaymentMethodLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.PaymentMethodLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PaymentMethodLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.PaymentMethodLovDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.PaymentMethodLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.PaymentMethodLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 