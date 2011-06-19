 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.RegionDs = [
	{name:"name",type:"string"}
	,	{name:"code",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"notes",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"iso",type:"string"}
	,	{name:"countryId",type:"int"}
	,	{name:"countryCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.RegionDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.RegionDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"RegionDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.RegionDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.RegionDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.RegionDs.superclass.constructor.call(this, config);
		}	 
	});  
 