 
   	 
Ext.ns("net.nan21.dnet.module.ad.report.ds.model");
	net.nan21.dnet.module.ad.report.ds.model.ReportParamDs = [
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
	,	{name:"reportId",type:"int"}
	,	{name:"reportCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds.param");	
	net.nan21.dnet.module.ad.report.ds.param.ReportParamDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds");	
	net.nan21.dnet.module.ad.report.ds.ReportParamDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ReportParamDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.report.ds.model.ReportParamDs
				,paramFields: net.nan21.dnet.module.ad.report.ds.param.ReportParamDsParam				 
			});
		 	net.nan21.dnet.module.ad.report.ds.ReportParamDs.superclass.constructor.call(this, config);
		}	 
	});  
 