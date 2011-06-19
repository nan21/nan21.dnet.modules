 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.LocationDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"regionName",type:"string"}
	,	{name:"cityName",type:"string"}
	,	{name:"adress",type:"string"}
	,	{name:"notes",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"countryId",type:"int"}
	,	{name:"countryCode",type:"string"}
	,	{name:"regionId",type:"int"}
	,	{name:"regionCode",type:"string"}
	,	{name:"cityId",type:"int"}
	,	{name:"shipping",type:"boolean"}
	,	{name:"billing",type:"boolean"}
	,	{name:"mailing",type:"boolean"}
	,	{name:"targetId",type:"int"}
	,	{name:"targetType",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.LocationDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.LocationDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LocationDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.LocationDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.LocationDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.LocationDs.superclass.constructor.call(this, config);
		}	 
	});  
 