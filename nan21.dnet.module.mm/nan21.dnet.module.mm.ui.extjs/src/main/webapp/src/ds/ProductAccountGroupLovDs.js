 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAccountGroupLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAccountGroupLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAccountGroupLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAccountGroupLovDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAccountGroupLovDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAccountGroupLovDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAccountGroupLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 