 
   	 
Ext.ns("net.nan21.dnet.module.bp.md.ds.model");
	net.nan21.dnet.module.bp.md.ds.model.ContactDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"firstName",type:"string"}
	,	{name:"lastName",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"gender",type:"string"}
	,	{name:"birthdate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"position",type:"string"}
	,	{name:"bpartnerId",type:"int"}
	,	{name:"bpartnerCode",type:"string"}
	,	{name:"className",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds.param");	
	net.nan21.dnet.module.bp.md.ds.param.ContactDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds");	
	net.nan21.dnet.module.bp.md.ds.ContactDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ContactDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.md.ds.model.ContactDs
				,paramFields: net.nan21.dnet.module.bp.md.ds.param.ContactDsParam				 
			});
		 	net.nan21.dnet.module.bp.md.ds.ContactDs.superclass.constructor.call(this, config);
		}	 
	});  
 