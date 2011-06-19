 
   	 
Ext.ns("net.nan21.dnet.module.bp.md.ds.model");
	net.nan21.dnet.module.bp.md.ds.model.BpBankAccountLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"accountNo",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds.param");	
	net.nan21.dnet.module.bp.md.ds.param.BpBankAccountLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds");	
	net.nan21.dnet.module.bp.md.ds.BpBankAccountLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"BpBankAccountLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.md.ds.model.BpBankAccountLovDs
				,paramFields: net.nan21.dnet.module.bp.md.ds.param.BpBankAccountLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.md.ds.BpBankAccountLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 