 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.CustomerGroupDs = [
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
Ext.ns("net.nan21.dnet.module.bp.base.ds.param");	
	net.nan21.dnet.module.bp.base.ds.param.CustomerGroupDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.CustomerGroupDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"CustomerGroupDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.CustomerGroupDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.CustomerGroupDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.CustomerGroupDs.superclass.constructor.call(this, config);
		}	 
	});  
 