 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.PEmplAttachmentDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.PEmplAttachmentDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.PEmplAttachmentDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PEmplAttachmentDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.PEmplAttachmentDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.PEmplAttachmentDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.PEmplAttachmentDs.superclass.constructor.call(this, config);
		}	 
	});  
 