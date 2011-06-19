 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.VendorGroupLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds.param");	
	net.nan21.dnet.module.bp.base.ds.param.VendorGroupLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.VendorGroupLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"VendorGroupLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.VendorGroupLovDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.VendorGroupLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.VendorGroupLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 