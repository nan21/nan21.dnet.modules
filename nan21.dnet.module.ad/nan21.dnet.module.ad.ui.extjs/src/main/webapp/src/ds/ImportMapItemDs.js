 
   	 
Ext.ns("net.nan21.dnet.module.ad.impex.ds.model");
	net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"importMapId",type:"int"}
	,	{name:"importMapName",type:"string"}
	,	{name:"sequenceNo",type:"int"}
	,	{name:"dataSource",type:"string"}
	,	{name:"fileName",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds.param");	
	net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds");	
	net.nan21.dnet.module.ad.impex.ds.ImportMapItemDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ImportMapItemDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs
				,paramFields: net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam				 
			});
		 	net.nan21.dnet.module.ad.impex.ds.ImportMapItemDs.superclass.constructor.call(this, config);
		}	 
	});  
 