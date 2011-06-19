 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"scaleRateId",type:"int"}
	,	{name:"scalePointId",type:"int"}
	,	{name:"scalePointCode",type:"string"}
	,	{name:"value",type:"float"}
	,	{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateValueDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.PayScaleRateValueDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PayScaleRateValueDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateValueDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.PayScaleRateValueDs.superclass.constructor.call(this, config);
		}	 
	});  
 