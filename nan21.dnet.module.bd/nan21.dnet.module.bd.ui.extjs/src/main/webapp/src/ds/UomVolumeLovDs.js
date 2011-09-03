 
   	 
Ext.ns("net.nan21.dnet.module.bd.uom.ds.model");
	net.nan21.dnet.module.bd.uom.ds.model.UomVolumeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds.param");	
	net.nan21.dnet.module.bd.uom.ds.param.UomVolumeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.uom.ds");	
	net.nan21.dnet.module.bd.uom.ds.UomVolumeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"UomVolumeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.uom.ds.model.UomVolumeLovDs
				,paramFields: net.nan21.dnet.module.bd.uom.ds.param.UomVolumeLovDsParam				 
			});
		 	net.nan21.dnet.module.bd.uom.ds.UomVolumeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 