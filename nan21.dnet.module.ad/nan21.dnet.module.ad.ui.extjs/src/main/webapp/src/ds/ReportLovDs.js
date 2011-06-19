 
   	 
Ext.ns("net.nan21.dnet.module.ad.report.ds.model");
	net.nan21.dnet.module.ad.report.ds.model.ReportLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds.param");	
	net.nan21.dnet.module.ad.report.ds.param.ReportLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.report.ds");	
	net.nan21.dnet.module.ad.report.ds.ReportLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ReportLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.report.ds.model.ReportLovDs
				,paramFields: net.nan21.dnet.module.ad.report.ds.param.ReportLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.report.ds.ReportLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 