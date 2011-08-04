 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.UserTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds.param");	
	net.nan21.dnet.module.ad.usr.ds.param.UserTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.UserTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UserTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.UserTypeLovDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.UserTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.UserTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 