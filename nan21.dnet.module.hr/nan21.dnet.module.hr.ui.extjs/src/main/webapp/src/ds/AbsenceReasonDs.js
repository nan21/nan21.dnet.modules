 
   	 
Ext.ns("net.nan21.dnet.module.hr.time.ds.model");
	net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonDs = [
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
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds.param");	
	net.nan21.dnet.module.hr.time.ds.param.AbsenceReasonDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds");	
	net.nan21.dnet.module.hr.time.ds.AbsenceReasonDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"AbsenceReasonDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonDs
				,paramFields: net.nan21.dnet.module.hr.time.ds.param.AbsenceReasonDsParam				 
			});
		 	net.nan21.dnet.module.hr.time.ds.AbsenceReasonDs.superclass.constructor.call(this, config);
		}	 
	});  
 