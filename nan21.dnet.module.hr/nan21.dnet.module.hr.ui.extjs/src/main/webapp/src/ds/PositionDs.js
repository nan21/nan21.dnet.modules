 
   	 
Ext.ns("net.nan21.dnet.module.hr.job.ds.model");
	net.nan21.dnet.module.hr.job.ds.model.PositionDs = [
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
	,	{name:"jobId",type:"int"}
	,	{name:"jobCode",type:"string"}
	,	{name:"organizationId",type:"int"}
	,	{name:"organizationCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds.param");	
	net.nan21.dnet.module.hr.job.ds.param.PositionDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.job.ds");	
	net.nan21.dnet.module.hr.job.ds.PositionDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PositionDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.job.ds.model.PositionDs
				,paramFields: net.nan21.dnet.module.hr.job.ds.param.PositionDsParam				 
			});
		 	net.nan21.dnet.module.hr.job.ds.PositionDs.superclass.constructor.call(this, config);
		}	 
	});  
 