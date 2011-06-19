 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.BankLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds.param");	
	net.nan21.dnet.module.bp.base.ds.param.BankLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.BankLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"BankLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.BankLovDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.BankLovDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.BankLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 