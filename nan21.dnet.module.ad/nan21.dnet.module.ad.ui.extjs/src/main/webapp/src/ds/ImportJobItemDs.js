 
   	 
Ext.ns("net.nan21.dnet.module.ad.impex.ds.model");
	net.nan21.dnet.module.ad.impex.ds.model.ImportJobItemDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"sequenceNo",type:"int"}
	,	{name:"active",type:"boolean"}
	,	{name:"jobId",type:"int"}
	,	{name:"jobName",type:"string"}
	,	{name:"mapId",type:"int"}
	,	{name:"mapName",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds.param");	
	net.nan21.dnet.module.ad.impex.ds.param.ImportJobItemDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.impex.ds");	
	net.nan21.dnet.module.ad.impex.ds.ImportJobItemDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ImportJobItemDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.impex.ds.model.ImportJobItemDs
				,paramFields: net.nan21.dnet.module.ad.impex.ds.param.ImportJobItemDsParam				 
			});
		 	net.nan21.dnet.module.ad.impex.ds.ImportJobItemDs.superclass.constructor.call(this, config);
		}	 
	});  
 