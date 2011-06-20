 
   	 
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.model");
	net.nan21.dnet.module.hr.payroll.ds.model.PayrollLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.param");	
	net.nan21.dnet.module.hr.payroll.ds.param.PayrollLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds");	
	net.nan21.dnet.module.hr.payroll.ds.PayrollLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PayrollLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.payroll.ds.model.PayrollLovDs
				,paramFields: net.nan21.dnet.module.hr.payroll.ds.param.PayrollLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.payroll.ds.PayrollLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 