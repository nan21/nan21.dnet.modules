 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean"},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"employerCode", type:"string"},
		{name:"businessObject", type:"string"},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"gender", type:"string"},
		{name:"maritalStatus", type:"string"},
		{name:"sinNo", type:"string"},
		{name:"ssnNo", type:"string"},
		{name:"hasDisability", type:"boolean"},
		{name:"firstHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currentHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"officeEmail", type:"string"},
		{name:"citizenshipId", type:"int", useNull:true},
		{name:"citizenshipCode", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"className", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"assignToPosition", type:"boolean"},
		{name:"gradeId", type:"int", useNull:true},
		{name:"gradeCode", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"jobName", type:"string"},
		{name:"positionId", type:"int", useNull:true},
		{name:"positionCode", type:"string"},
		{name:"positionName", type:"string"},
		{name:"posOrgId", type:"int", useNull:true},
		{name:"posOrgCode", type:"string"},
		{name:"organizationId", type:"int", useNull:true},
		{name:"organizationCode", type:"string"},
		{name:"baseSalary", type:"float", useNull:true},
		{name:"payrollId", type:"int", useNull:true},
		{name:"payroll", type:"string"}
	],
	validations: [  
		{field: "firstName", type: 'presence'}, 
		{field: "lastName", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"employerId", type:"int", useNull:true},
		{name:"employerId_From",type:"int", useNull:true},
		{name:"employerId_To",type:"int", useNull:true},
		{name:"employerCode", type:"string"},
		{name:"businessObject", type:"string"},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthdate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthdate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"gender", type:"string"},
		{name:"maritalStatus", type:"string"},
		{name:"sinNo", type:"string"},
		{name:"ssnNo", type:"string"},
		{name:"hasDisability", type:"boolean", useNull:true},
		{name:"firstHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"firstHireDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"firstHireDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currentHireDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currentHireDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currentHireDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"officeEmail", type:"string"},
		{name:"citizenshipId", type:"int", useNull:true},
		{name:"citizenshipId_From",type:"int", useNull:true},
		{name:"citizenshipId_To",type:"int", useNull:true},
		{name:"citizenshipCode", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"className", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"assignToPosition", type:"boolean", useNull:true},
		{name:"gradeId", type:"int", useNull:true},
		{name:"gradeId_From",type:"int", useNull:true},
		{name:"gradeId_To",type:"int", useNull:true},
		{name:"gradeCode", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobId_From",type:"int", useNull:true},
		{name:"jobId_To",type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"jobName", type:"string"},
		{name:"positionId", type:"int", useNull:true},
		{name:"positionId_From",type:"int", useNull:true},
		{name:"positionId_To",type:"int", useNull:true},
		{name:"positionCode", type:"string"},
		{name:"positionName", type:"string"},
		{name:"posOrgId", type:"int", useNull:true},
		{name:"posOrgId_From",type:"int", useNull:true},
		{name:"posOrgId_To",type:"int", useNull:true},
		{name:"posOrgCode", type:"string"},
		{name:"organizationId", type:"int", useNull:true},
		{name:"organizationId_From",type:"int", useNull:true},
		{name:"organizationId_To",type:"int", useNull:true},
		{name:"organizationCode", type:"string"},
		{name:"baseSalary", type:"float", useNull:true},
		{name:"baseSalary_From",type:"float", useNull:true},
		{name:"baseSalary_To",type:"float", useNull:true},
		{name:"payrollId", type:"int", useNull:true},
		{name:"payrollId_From",type:"int", useNull:true},
		{name:"payrollId_To",type:"int", useNull:true},
		{name:"payroll", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 