 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactDs" , {
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
		{name:"firstName",type:"string" },
		{name:"lastName",type:"string" },
		{name:"birthdate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"gender",type:"string" },
		{name:"relationshipId",type:"int", useNull:true },
		{name:"relationship",type:"string" },
		{name:"isDependent",type:"boolean" }
	],
	validations: [  
		{field: "firstName", type: 'presence'}, 
		{field: "lastName", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeContactDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 