 
   	 
Ext.ns("net.nan21.dnet.module.ux.example.ds.model");
	net.nan21.dnet.module.ux.example.ds.model.LandFormTypeDs = [
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
Ext.ns("net.nan21.dnet.module.ux.example.ds.param");	
	net.nan21.dnet.module.ux.example.ds.param.LandFormTypeDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ux.example.ds");	
	net.nan21.dnet.module.ux.example.ds.LandFormTypeDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"LandFormTypeDs" 				 		
				,recordFields: net.nan21.dnet.module.ux.example.ds.model.LandFormTypeDs
				,paramFields: net.nan21.dnet.module.ux.example.ds.param.LandFormTypeDsParam				 
			});
		 	net.nan21.dnet.module.ux.example.ds.LandFormTypeDs.superclass.constructor.call(this, config);
		}	 
	});  
 