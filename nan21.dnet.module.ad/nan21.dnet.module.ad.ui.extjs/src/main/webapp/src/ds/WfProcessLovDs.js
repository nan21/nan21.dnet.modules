 
   	 
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.model");
	net.nan21.dnet.module.ad.workflow.ds.model.WfProcessLovDs = [
	{name:"id",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"fullName",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds.param");	
	net.nan21.dnet.module.ad.workflow.ds.param.WfProcessLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.workflow.ds");	
	net.nan21.dnet.module.ad.workflow.ds.WfProcessLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"WfProcessLovDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.workflow.ds.model.WfProcessLovDs
				,paramFields: net.nan21.dnet.module.ad.workflow.ds.param.WfProcessLovDsParam				 
			});
		 	net.nan21.dnet.module.ad.workflow.ds.WfProcessLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 