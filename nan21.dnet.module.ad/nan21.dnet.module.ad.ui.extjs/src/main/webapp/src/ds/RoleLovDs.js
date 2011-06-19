 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.RoleLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds.param");	
	net.nan21.dnet.module.ad.usr.ds.param.RoleLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.RoleLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"RoleLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.RoleLovDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.RoleLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.RoleLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 