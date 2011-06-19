 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.CityDs = [
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
	,	{name:"countryId",type:"int"}
	,	{name:"countryCode",type:"string"}
	,	{name:"regionId",type:"int"}
	,	{name:"regionCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.CityDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.CityDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CityDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.CityDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.CityDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.CityDs.superclass.constructor.call(this, config);
		}	 
	});  
 