 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttributeTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttributeTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttributeTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttributeTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttributeTypeLovDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttributeTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttributeTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 