 
   	 
Ext.ns("net.nan21.dnet.module.ad.report.ds.model");
	net.nan21.dnet.module.ad.report.ds.model.ReportServerLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds.param");	
	net.nan21.dnet.module.ad.report.ds.param.ReportServerLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds");	
	net.nan21.dnet.module.ad.report.ds.ReportServerLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ReportServerLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.report.ds.model.ReportServerLovDs
				,paramFields: net.nan21.dnet.module.ad.report.ds.param.ReportServerLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.report.ds.ReportServerLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 