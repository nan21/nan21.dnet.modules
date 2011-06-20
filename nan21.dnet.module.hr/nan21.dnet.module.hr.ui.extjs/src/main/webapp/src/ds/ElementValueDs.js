 
   	 
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.model");
	net.nan21.dnet.module.hr.payroll.ds.model.ElementValueDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"elementId",type:"int"}
	,	{name:"element",type:"string"}
	,	{name:"employeeId",type:"int"}
	,	{name:"employeeName",type:"string"}
	,	{name:"value",type:"string"}
	,	{name:"periodId",type:"int"}
	,	{name:"period",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds.param");	
	net.nan21.dnet.module.hr.payroll.ds.param.ElementValueDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.payroll.ds");	
	net.nan21.dnet.module.hr.payroll.ds.ElementValueDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ElementValueDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.payroll.ds.model.ElementValueDs
				,paramFields: net.nan21.dnet.module.hr.payroll.ds.param.ElementValueDsParam				 
			});
		 	net.nan21.dnet.module.hr.payroll.ds.ElementValueDs.superclass.constructor.call(this, config);
		}	 
	});  
 