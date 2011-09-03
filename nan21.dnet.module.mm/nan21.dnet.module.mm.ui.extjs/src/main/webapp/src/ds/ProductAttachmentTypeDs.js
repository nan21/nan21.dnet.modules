 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentTypeDs = [
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
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttachmentTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttachmentTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttachmentTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentTypeDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttachmentTypeDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttachmentTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 