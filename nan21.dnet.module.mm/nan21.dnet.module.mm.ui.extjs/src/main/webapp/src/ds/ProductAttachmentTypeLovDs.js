 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttachmentTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttachmentTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttachmentTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentTypeLovDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttachmentTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttachmentTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 