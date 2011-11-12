 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeLicenseDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"employeeId",type:"int", useNull:true },
		{name:"licenseTypeId",type:"int", useNull:true },
		{name:"licenseType",type:"string" },
		{name:"documentNo",type:"string" },
		{name:"issuedBy",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"notes",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeLicenseDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"employeeId",type:"int", useNull:true },
		{name:"licenseTypeId",type:"int", useNull:true },
		{name:"licenseType",type:"string" },
		{name:"documentNo",type:"string" },
		{name:"issuedBy",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"notes",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeLicenseDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 