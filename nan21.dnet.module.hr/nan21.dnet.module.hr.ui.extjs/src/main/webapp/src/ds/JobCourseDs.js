 
   	 
Ext.ns("net.nan21.dnet.module.hr.training.ds.model");
	net.nan21.dnet.module.hr.training.ds.model.JobCourseDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"jobId",type:"int"}
	,	{name:"jobCode",type:"string"}
	,	{name:"jobName",type:"string"}
	,	{name:"courseId",type:"int"}
	,	{name:"courseCode",type:"string"}
	,	{name:"courseName",type:"string"}
	,	{name:"mandatory",type:"boolean"}
	,	{name:"validFor",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds.param");	
	net.nan21.dnet.module.hr.training.ds.param.JobCourseDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds");	
	net.nan21.dnet.module.hr.training.ds.JobCourseDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"JobCourseDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.training.ds.model.JobCourseDs
				,paramFields: net.nan21.dnet.module.hr.training.ds.param.JobCourseDsParam				 
			});
		 	net.nan21.dnet.module.hr.training.ds.JobCourseDs.superclass.constructor.call(this, config);
		}	 
	});  
 