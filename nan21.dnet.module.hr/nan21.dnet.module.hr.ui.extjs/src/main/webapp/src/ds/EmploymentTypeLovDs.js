 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmploymentTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmploymentTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmploymentTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmploymentTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmploymentTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 