 
   	 
Ext.ns("net.nan21.dnet.module.bp.md.ds.model");
	net.nan21.dnet.module.bp.md.ds.model.ContactLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds.param");	
	net.nan21.dnet.module.bp.md.ds.param.ContactLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds");	
	net.nan21.dnet.module.bp.md.ds.ContactLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ContactLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.md.ds.model.ContactLovDs
				,paramFields: net.nan21.dnet.module.bp.md.ds.param.ContactLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.md.ds.ContactLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 