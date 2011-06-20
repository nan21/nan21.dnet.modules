 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmployeeLicenseDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"employeeId",type:"int"}
	,	{name:"licenseTypeId",type:"int"}
	,	{name:"licenseType",type:"string"}
	,	{name:"documentNo",type:"string"}
	,	{name:"issuedBy",type:"string"}
	,	{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"notes",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmployeeLicenseDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmployeeLicenseDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmployeeLicenseDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmployeeLicenseDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmployeeLicenseDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmployeeLicenseDs.superclass.constructor.call(this, config);
		}	 
	});  
 