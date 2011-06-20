 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"employerId",type:"int"}
	,	{name:"employerCode",type:"string"}
	,	{name:"code",type:"string"}
	,	{name:"firstName",type:"string"}
	,	{name:"lastName",type:"string"}
	,	{name:"middleName",type:"string"}
	,	{name:"birthdate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"gender",type:"string"}
	,	{name:"maritalStatus",type:"string"}
	,	{name:"sinNo",type:"string"}
	,	{name:"ssnNo",type:"string"}
	,	{name:"hasDisability",type:"boolean"}
	,	{name:"firstHireDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"currentHireDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"officeEmail",type:"string"}
	,	{name:"citizenshipId",type:"int"}
	,	{name:"citizenshipCode",type:"string"}
	,	{name:"passportNo",type:"string"}
	,	{name:"className",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmployeeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmployeeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmployeeDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmployeeDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmployeeDs.superclass.constructor.call(this, config);
		}	 
	});  
 