 
   	 
Ext.ns("net.nan21.dnet.module.ad.impex.ds.model");
	net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs = [
	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"description",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds.param");	
	net.nan21.dnet.module.ad.impex.ds.param.ImportMapDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds");	
	net.nan21.dnet.module.ad.impex.ds.ImportMapDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ImportMapDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.impex.ds.model.ImportMapDs
				,paramFields: net.nan21.dnet.module.ad.impex.ds.param.ImportMapDsParam				 
			});
		 	net.nan21.dnet.module.ad.impex.ds.ImportMapDs.superclass.constructor.call(this, config);
		}	 
	});  
 