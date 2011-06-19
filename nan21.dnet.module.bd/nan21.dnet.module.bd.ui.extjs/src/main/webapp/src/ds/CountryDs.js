 
   	 
Ext.ns("net.nan21.dnet.module.bd.geo.ds.model");
	net.nan21.dnet.module.bd.geo.ds.model.CountryDs = [
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
	,	{name:"iso2",type:"string"}
	,	{name:"iso3",type:"string"}
	,	{name:"hasRegions",type:"boolean"}
	,	{name:"currency",type:"string"}
	,	{name:"language",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds.param");	
	net.nan21.dnet.module.bd.geo.ds.param.CountryDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bd.geo.ds");	
	net.nan21.dnet.module.bd.geo.ds.CountryDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CountryDs" 				 		
				,recordFields: net.nan21.dnet.module.bd.geo.ds.model.CountryDs
				,paramFields: net.nan21.dnet.module.bd.geo.ds.param.CountryDsParam				 
			});
		 	net.nan21.dnet.module.bd.geo.ds.CountryDs.superclass.constructor.call(this, config);
		}	 
	});  
 