 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"employeeId",type:"int"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"location",type:"string"}
	,	{name:"notes",type:"string"}
	,	{name:"url",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmplAttachmentDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmplAttachmentDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmplAttachmentDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmplAttachmentDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmplAttachmentDs.superclass.constructor.call(this, config);
		}	 
	});  
 