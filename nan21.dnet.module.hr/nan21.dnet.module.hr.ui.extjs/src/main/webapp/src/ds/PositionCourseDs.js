 
   	 
Ext.ns("net.nan21.dnet.module.hr.training.ds.model");
	net.nan21.dnet.module.hr.training.ds.model.PositionCourseDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"positionId",type:"int"}
	,	{name:"positionCode",type:"string"}
	,	{name:"positionName",type:"string"}
	,	{name:"courseId",type:"int"}
	,	{name:"courseCode",type:"string"}
	,	{name:"courseName",type:"string"}
	,	{name:"mandatory",type:"boolean"}
	,	{name:"validFor",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds.param");	
	net.nan21.dnet.module.hr.training.ds.param.PositionCourseDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds");	
	net.nan21.dnet.module.hr.training.ds.PositionCourseDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PositionCourseDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.training.ds.model.PositionCourseDs
				,paramFields: net.nan21.dnet.module.hr.training.ds.param.PositionCourseDsParam				 
			});
		 	net.nan21.dnet.module.hr.training.ds.PositionCourseDs.superclass.constructor.call(this, config);
		}	 
	});  
 