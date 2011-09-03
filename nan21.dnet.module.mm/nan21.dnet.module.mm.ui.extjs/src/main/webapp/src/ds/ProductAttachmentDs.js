 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"productId",type:"int"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"location",type:"string"}
	,	{name:"notes",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttachmentDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttachmentDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttachmentDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttachmentDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttachmentDs.superclass.constructor.call(this, config);
		}	 
	});  
 