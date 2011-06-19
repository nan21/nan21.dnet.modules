 
   	 
Ext.ns("net.nan21.dnet.module.mm.md.ds.model");
	net.nan21.dnet.module.mm.md.ds.model.ProductAccountGroupDs = [
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
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds.param");	
	net.nan21.dnet.module.mm.md.ds.param.ProductAccountGroupDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.mm.md.ds");	
	net.nan21.dnet.module.mm.md.ds.ProductAccountGroupDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"ProductAccountGroupDs" 				 		
				,recordFields: net.nan21.dnet.module.mm.md.ds.model.ProductAccountGroupDs
				,paramFields: net.nan21.dnet.module.mm.md.ds.param.ProductAccountGroupDsParam				 
			});
		 	net.nan21.dnet.module.mm.md.ds.ProductAccountGroupDs.superclass.constructor.call(this, config);
		}	 
	});  
 