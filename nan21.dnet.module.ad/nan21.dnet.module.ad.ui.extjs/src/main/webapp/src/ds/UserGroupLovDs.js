 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.UserGroupLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds.param");	
	net.nan21.dnet.module.ad.usr.ds.param.UserGroupLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.UserGroupLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UserGroupLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.UserGroupLovDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.UserGroupLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.UserGroupLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 