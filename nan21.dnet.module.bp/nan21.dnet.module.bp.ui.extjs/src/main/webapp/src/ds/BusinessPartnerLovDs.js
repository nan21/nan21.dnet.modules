 
   	 
Ext.ns("net.nan21.dnet.module.bp.md.ds.model");
	net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds.param");	
	net.nan21.dnet.module.bp.md.ds.param.BusinessPartnerLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds");	
	net.nan21.dnet.module.bp.md.ds.BusinessPartnerLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"BusinessPartnerLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerLovDs
				,paramFields: net.nan21.dnet.module.bp.md.ds.param.BusinessPartnerLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.md.ds.BusinessPartnerLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 