 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.UserLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds.param");	
	net.nan21.dnet.module.ad.usr.ds.param.UserLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.UserLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UserLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.UserLovDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.UserLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.UserLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 