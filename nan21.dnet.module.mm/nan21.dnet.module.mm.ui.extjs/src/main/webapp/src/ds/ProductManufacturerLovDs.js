 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductManufacturerLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductManufacturerLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductManufacturerLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductManufacturerLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductManufacturerLovDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductManufacturerLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductManufacturerLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 