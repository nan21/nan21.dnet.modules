 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.AccessControlLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds.param");	
	net.nan21.dnet.module.ad.usr.ds.param.AccessControlLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.AccessControlLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"AccessControlLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.AccessControlLovDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.AccessControlLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.AccessControlLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 