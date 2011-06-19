 
   	 
Ext.ns("net.nan21.dnet.module.ad.report.ds.model");
	net.nan21.dnet.module.ad.report.ds.model.DsReportDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"reportId",type:"int"}
	,	{name:"reportCode",type:"string"}
	,	{name:"dataSource",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds.param");	
	net.nan21.dnet.module.ad.report.ds.param.DsReportDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds");	
	net.nan21.dnet.module.ad.report.ds.DsReportDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"DsReportDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.report.ds.model.DsReportDs
				,paramFields: net.nan21.dnet.module.ad.report.ds.param.DsReportDsParam				 
			});
		 	net.nan21.dnet.module.ad.report.ds.DsReportDs.superclass.constructor.call(this, config);
		}	 
	});  
 