 
   	 
Ext.ns("net.nan21.dnet.module.bd.uom.ds.model");
	net.nan21.dnet.module.bd.uom.ds.model.UomMassLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds.param");	
	net.nan21.dnet.module.bd.uom.ds.param.UomMassLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds");	
	net.nan21.dnet.module.bd.uom.ds.UomMassLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UomMassLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.uom.ds.model.UomMassLovDs
				,paramFields: net.nan21.dnet.module.bd.uom.ds.param.UomMassLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.uom.ds.UomMassLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 