 
   	 
Ext.ns("net.nan21.dnet.module.hr.time.ds.model");
	net.nan21.dnet.module.hr.time.ds.model.AbsenceDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"employeeId",type:"int"}
	,	{name:"employeeCode",type:"string"}
	,	{name:"employee",type:"string"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"reasonId",type:"int"}
	,	{name:"reason",type:"string"}
	,	{name:"eventDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"hours",type:"int"}
	,	{name:"notes",type:"string"}
	,	{name:"posted",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds.param");	
	net.nan21.dnet.module.hr.time.ds.param.AbsenceDsParam = [
	{name:"from",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"to",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds");	
	net.nan21.dnet.module.hr.time.ds.AbsenceDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"AbsenceDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.time.ds.model.AbsenceDs
				,paramFields: net.nan21.dnet.module.hr.time.ds.param.AbsenceDsParam				 
			});
		 	net.nan21.dnet.module.hr.time.ds.AbsenceDs.superclass.constructor.call(this, config);
		}	 
	});  
 