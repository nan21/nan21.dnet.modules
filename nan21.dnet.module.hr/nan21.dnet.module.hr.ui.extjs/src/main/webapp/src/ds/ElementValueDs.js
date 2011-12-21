 
   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.ElementValueDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"elementId",type:"int", useNull:true },
		{name:"element",type:"string" },
		{name:"employeeId",type:"int", useNull:true },
		{name:"employeeName",type:"string" },
		{name:"value",type:"string" },
		{name:"periodId",type:"int", useNull:true },
		{name:"period",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.ElementValueDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"elementId",type:"int", useNull:true },
		{name:"element",type:"string" },
		{name:"employeeId",type:"int", useNull:true },
		{name:"employeeName",type:"string" },
		{name:"value",type:"string" },
		{name:"periodId",type:"int", useNull:true },
		{name:"period",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.ElementValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 