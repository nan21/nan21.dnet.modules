 
   	 
Ext.ns("net.nan21.dnet.module.ad.usr.ds.model");
	net.nan21.dnet.module.ad.usr.ds.model.RolesOfUserLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds.param");	
	net.nan21.dnet.module.ad.usr.ds.param.RolesOfUserLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.usr.ds");	
	net.nan21.dnet.module.ad.usr.ds.RolesOfUserLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"RolesOfUserLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.usr.ds.model.RolesOfUserLovDs
				,paramFields: net.nan21.dnet.module.ad.usr.ds.param.RolesOfUserLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.usr.ds.RolesOfUserLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 