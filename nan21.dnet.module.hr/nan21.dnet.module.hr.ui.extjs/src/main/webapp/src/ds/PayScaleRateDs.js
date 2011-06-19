 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDs = [
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
	,	{name:"payScaleId",type:"int"}
	,	{name:"payScaleCode",type:"string"}
	,	{name:"payScaleName",type:"string"}
	,	{name:"currencyId",type:"int"}
	,	{name:"currencyCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.PayScaleRateDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PayScaleRateDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.PayScaleRateDs.superclass.constructor.call(this, config);
		}	 
	});  
 