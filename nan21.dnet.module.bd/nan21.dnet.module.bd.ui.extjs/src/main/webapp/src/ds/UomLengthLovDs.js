 
   	 
Ext.ns("net.nan21.dnet.module.bd.uom.ds.model");
	net.nan21.dnet.module.bd.uom.ds.model.UomLengthLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds.param");	
	net.nan21.dnet.module.bd.uom.ds.param.UomLengthLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds");	
	net.nan21.dnet.module.bd.uom.ds.UomLengthLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UomLengthLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.uom.ds.model.UomLengthLovDs
				,paramFields: net.nan21.dnet.module.bd.uom.ds.param.UomLengthLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.uom.ds.UomLengthLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 