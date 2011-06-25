 
   	 
Ext.ns("net.nan21.dnet.module.ux.example.ds.model");
	net.nan21.dnet.module.ux.example.ds.model.LandFormDs = [
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
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"countryId",type:"int"}
	,	{name:"countryCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ux.example.ds.param");	
	net.nan21.dnet.module.ux.example.ds.param.LandFormDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ux.example.ds");	
	net.nan21.dnet.module.ux.example.ds.LandFormDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LandFormDs" 				 		
				,recordFields: net.nan21.dnet.module.ux.example.ds.model.LandFormDs
				,paramFields: net.nan21.dnet.module.ux.example.ds.param.LandFormDsParam				 
			});
		 	net.nan21.dnet.module.ux.example.ds.LandFormDs.superclass.constructor.call(this, config);
		}	 
	});  
 