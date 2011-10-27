 
   	 
Ext.define("net.nan21.dnet.module.hr.training.ds.model.JobCourseDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"jobId",type:"int", useNull:true },
		{name:"jobCode",type:"string" },
		{name:"jobName",type:"string" },
		{name:"courseId",type:"int", useNull:true },
		{name:"courseCode",type:"string" },
		{name:"courseName",type:"string" },
		{name:"mandatory",type:"boolean" },
		{name:"validFor",type:"int", useNull:true }
	],
	validations: [ 
	]
});

Ext.define("net.nan21.dnet.module.hr.training.ds.model.JobCourseDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"jobId",type:"int", useNull:true },
		{name:"jobCode",type:"string" },
		{name:"jobName",type:"string" },
		{name:"courseId",type:"int", useNull:true },
		{name:"courseCode",type:"string" },
		{name:"courseName",type:"string" },
		{name:"mandatory",type:"boolean", useNull:true },
		{name:"validFor",type:"int", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.training.ds.param.JobCourseDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 