 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductCategoryLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductCategoryLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductCategoryLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductCategoryLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductCategoryLovDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductCategoryLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductCategoryLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 