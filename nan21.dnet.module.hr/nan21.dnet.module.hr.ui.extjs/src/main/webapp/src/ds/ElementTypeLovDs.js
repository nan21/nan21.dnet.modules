 
   	 
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.model");
	net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.param");	
	net.nan21.dnet.module.hr.payroll.ds.param.ElementTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds");	
	net.nan21.dnet.module.hr.payroll.ds.ElementTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ElementTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.payroll.ds.param.ElementTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.payroll.ds.ElementTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 