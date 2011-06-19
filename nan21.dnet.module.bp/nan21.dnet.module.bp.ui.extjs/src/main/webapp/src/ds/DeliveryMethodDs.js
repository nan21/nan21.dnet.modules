 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodDs = [
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
Ext.ns("net.nan21.dnet.module.bp.base.ds.param");	
	net.nan21.dnet.module.bp.base.ds.param.DeliveryMethodDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.DeliveryMethodDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"DeliveryMethodDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.DeliveryMethodDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.DeliveryMethodDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.DeliveryMethodDs.superclass.constructor.call(this, config);
		}	 
	});  
 