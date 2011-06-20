 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"employeeId",type:"int"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"fromDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"toDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"institute",type:"string"}
	,	{name:"degree",type:"string"}
	,	{name:"notes",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmployeeEducationDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmployeeEducationDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmployeeEducationDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmployeeEducationDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmployeeEducationDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmployeeEducationDs.superclass.constructor.call(this, config);
		}	 
	});  
 