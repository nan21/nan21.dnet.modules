 
   	 
Ext.ns("net.nan21.dnet.module.hr.training.ds.model");
	net.nan21.dnet.module.hr.training.ds.model.CourseTypeDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"categoryId",type:"int"}
	,	{name:"category",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds.param");	
	net.nan21.dnet.module.hr.training.ds.param.CourseTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.training.ds");	
	net.nan21.dnet.module.hr.training.ds.CourseTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CourseTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.training.ds.model.CourseTypeDs
				,paramFields: net.nan21.dnet.module.hr.training.ds.param.CourseTypeDsParam				 
			});
		 	net.nan21.dnet.module.hr.training.ds.CourseTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 