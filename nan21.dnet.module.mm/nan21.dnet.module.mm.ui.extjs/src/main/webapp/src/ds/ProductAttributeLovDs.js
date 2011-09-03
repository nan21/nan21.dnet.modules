 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAttributeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAttributeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAttributeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAttributeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAttributeLovDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAttributeLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAttributeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 