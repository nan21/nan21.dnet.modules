 
   	 
Ext.ns("net.nan21.dnet.module.ad.org.ds.model");
	net.nan21.dnet.module.ad.org.ds.model.OrganizationDs = [
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
	,	{name:"valid",type:"boolean"}
	,	{name:"typeId",type:"int"}
	,	{name:"type",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.ad.org.ds.param");	
	net.nan21.dnet.module.ad.org.ds.param.OrganizationDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.ad.org.ds");	
	net.nan21.dnet.module.ad.org.ds.OrganizationDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"OrganizationDs" 				 		
				,recordFields: net.nan21.dnet.module.ad.org.ds.model.OrganizationDs
				,paramFields: net.nan21.dnet.module.ad.org.ds.param.OrganizationDsParam				 
			});
		 	net.nan21.dnet.module.ad.org.ds.OrganizationDs.superclass.constructor.call(this, config);
		}	 
	});  
 