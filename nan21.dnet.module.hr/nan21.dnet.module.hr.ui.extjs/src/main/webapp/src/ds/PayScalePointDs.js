 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.PayScalePointDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"payScaleId",type:"int"}
	,	{name:"sequenceNo",type:"int"}
	,	{name:"code",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.PayScalePointDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.PayScalePointDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PayScalePointDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.PayScalePointDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.PayScalePointDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.PayScalePointDs.superclass.constructor.call(this, config);
		}	 
	});  
 