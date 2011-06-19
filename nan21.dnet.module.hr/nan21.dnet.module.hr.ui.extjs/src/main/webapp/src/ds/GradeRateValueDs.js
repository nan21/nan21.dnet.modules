 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"gradeId",type:"int"}
	,	{name:"gradeName",type:"string"}
	,	{name:"gradeRateId",type:"int"}
	,	{name:"gradeRateName",type:"string"}
	,	{name:"fixValue",type:"float"}
	,	{name:"minValue",type:"float"}
	,	{name:"maxValue",type:"float"}
	,	{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.GradeRateValueDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.GradeRateValueDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"GradeRateValueDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.GradeRateValueDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.GradeRateValueDs.superclass.constructor.call(this, config);
		}	 
	});  
 