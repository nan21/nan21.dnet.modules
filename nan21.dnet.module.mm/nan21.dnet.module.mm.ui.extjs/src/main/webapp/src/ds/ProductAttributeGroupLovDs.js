 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttributeGroupLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttributeGroupLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttributeGroupLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttributeGroupLovDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttributeGroupLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttributeGroupLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 