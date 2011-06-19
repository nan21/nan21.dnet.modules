 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.PaymentTermLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds.param");	
	net.nan21.dnet.module.bp.base.ds.param.PaymentTermLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.PaymentTermLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PaymentTermLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.PaymentTermLovDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.PaymentTermLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.PaymentTermLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 