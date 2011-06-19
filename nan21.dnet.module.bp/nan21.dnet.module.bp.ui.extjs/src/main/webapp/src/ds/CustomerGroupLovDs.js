 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.CustomerGroupLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds.param");	
	net.nan21.dnet.module.bp.base.ds.param.CustomerGroupLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.CustomerGroupLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CustomerGroupLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.CustomerGroupLovDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.CustomerGroupLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.CustomerGroupLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 