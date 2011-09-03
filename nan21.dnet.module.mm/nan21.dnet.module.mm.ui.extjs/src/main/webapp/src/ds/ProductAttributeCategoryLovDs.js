 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttributeCategoryLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttributeCategoryLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttributeCategoryLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttributeCategoryLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttributeCategoryLovDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttributeCategoryLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttributeCategoryLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 