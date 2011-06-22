 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfDefNodeTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfDefNodeTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeTypeLovDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfDefNodeTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 