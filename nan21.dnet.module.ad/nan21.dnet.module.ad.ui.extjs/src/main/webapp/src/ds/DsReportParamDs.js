 
   	 
Ext.ns("net.nan21.dnet.module.ad.report.ds.model");
	net.nan21.dnet.module.ad.report.ds.model.DsReportParamDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"dsReportId",type:"int"}
	,	{name:"reportId",type:"int"}
	,	{name:"reportCode",type:"string"}
	,	{name:"paramId",type:"int"}
	,	{name:"paramCode",type:"string"}
	,	{name:"paramName",type:"string"}
	,	{name:"dataSource",type:"string"}
	,	{name:"dsField",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds.param");	
	net.nan21.dnet.module.ad.report.ds.param.DsReportParamDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds");	
	net.nan21.dnet.module.ad.report.ds.DsReportParamDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"DsReportParamDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.report.ds.model.DsReportParamDs
				,paramFields: net.nan21.dnet.module.ad.report.ds.param.DsReportParamDsParam				 
			});
		 	net.nan21.dnet.module.ad.report.ds.DsReportParamDs.superclass.constructor.call(this, config);
		}	 
	});  
 