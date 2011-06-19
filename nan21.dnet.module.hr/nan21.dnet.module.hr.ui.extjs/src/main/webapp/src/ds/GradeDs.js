 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.GradeDs = [
	{name:"name",type:"string"}
	,	{name:"code",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"notes",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"sequenceNo",type:"int"}
	,	{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.GradeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.GradeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"GradeDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.GradeDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.GradeDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.GradeDs.superclass.constructor.call(this, config);
		}	 
	});  
 