 
   	 
Ext.ns("net.nan21.dnet.module.hr.employee.ds.model");
	net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentTypeDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"category",type:"string"}
	,	{name:"uploadPath",type:"string"}
	,	{name:"baseUrl",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds.param");	
	net.nan21.dnet.module.hr.employee.ds.param.EmplAttachmentTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.employee.ds");	
	net.nan21.dnet.module.hr.employee.ds.EmplAttachmentTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"EmplAttachmentTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentTypeDs
				,paramFields: net.nan21.dnet.module.hr.employee.ds.param.EmplAttachmentTypeDsParam				 
			});
		 	net.nan21.dnet.module.hr.employee.ds.EmplAttachmentTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 