 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAccountDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"organizationId",type:"int"}
	,	{name:"organizationCode",type:"string"}
	,	{name:"groupId",type:"int"}
	,	{name:"groupCode",type:"string"}
	,	{name:"productId",type:"int"}
	,	{name:"productCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAccountDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAccountDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAccountDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAccountDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAccountDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAccountDs.superclass.constructor.call(this, config);
		}	 
	});  
 