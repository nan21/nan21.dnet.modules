 
   	 
Ext.ns("net.nan21.dnet.module.bp.md.ds.model");
	net.nan21.dnet.module.bp.md.ds.model.BpContactLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"bpartnerId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds.param");	
	net.nan21.dnet.module.bp.md.ds.param.BpContactLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds");	
	net.nan21.dnet.module.bp.md.ds.BpContactLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"BpContactLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.md.ds.model.BpContactLovDs
				,paramFields: net.nan21.dnet.module.bp.md.ds.param.BpContactLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.md.ds.BpContactLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 