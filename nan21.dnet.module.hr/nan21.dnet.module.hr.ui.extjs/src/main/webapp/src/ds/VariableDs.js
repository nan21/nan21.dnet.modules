 
   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.VariableDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"elementId",type:"int", useNull:true },
		{name:"element",type:"string" },
		{name:"crossReferenceId",type:"int", useNull:true },
		{name:"crossReference",type:"string" }
	],
	validations: [  
		{field: "code", type: 'presence'}, 
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.VariableDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"elementId",type:"int", useNull:true },
		{name:"element",type:"string" },
		{name:"crossReferenceId",type:"int", useNull:true },
		{name:"crossReference",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.VariableDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 