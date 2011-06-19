 
   	 
Ext.ns("net.nan21.dnet.module.ad.report.ds.model");
	net.nan21.dnet.module.ad.report.ds.model.ReportParamLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"reportId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds.param");	
	net.nan21.dnet.module.ad.report.ds.param.ReportParamLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds");	
	net.nan21.dnet.module.ad.report.ds.ReportParamLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ReportParamLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.report.ds.model.ReportParamLovDs
				,paramFields: net.nan21.dnet.module.ad.report.ds.param.ReportParamLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.report.ds.ReportParamLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 