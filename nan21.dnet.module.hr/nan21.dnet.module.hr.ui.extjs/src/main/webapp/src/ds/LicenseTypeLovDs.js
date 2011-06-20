 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.LicenseTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.LicenseTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.LicenseTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LicenseTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.LicenseTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.LicenseTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.LicenseTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 