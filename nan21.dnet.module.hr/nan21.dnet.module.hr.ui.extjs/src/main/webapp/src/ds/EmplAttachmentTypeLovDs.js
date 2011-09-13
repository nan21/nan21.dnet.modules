 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmplAttachmentTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmplAttachmentTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmplAttachmentTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmplAttachmentTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmplAttachmentTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 