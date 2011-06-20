 
   	 
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.model");
	net.nan21.dnet.module.hr.payroll.ds.model.PayrollDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"periodType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.param");	
	net.nan21.dnet.module.hr.payroll.ds.param.PayrollDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds");	
	net.nan21.dnet.module.hr.payroll.ds.PayrollDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PayrollDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.payroll.ds.model.PayrollDs
				,paramFields: net.nan21.dnet.module.hr.payroll.ds.param.PayrollDsParam				 
			});
		 	net.nan21.dnet.module.hr.payroll.ds.PayrollDs.superclass.constructor.call(this, config);
		}	 
	});  
 