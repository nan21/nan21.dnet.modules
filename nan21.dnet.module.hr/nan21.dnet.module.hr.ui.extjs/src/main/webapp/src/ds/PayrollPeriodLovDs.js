 
   	 
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.model");
	net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"startDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"endDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"active",type:"boolean"}
	,	{name:"payrollId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.param");	
	net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds");	
	net.nan21.dnet.module.hr.payroll.ds.PayrollPeriodLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PayrollPeriodLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs
				,paramFields: net.nan21.dnet.module.hr.payroll.ds.param.PayrollPeriodLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.payroll.ds.PayrollPeriodLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 