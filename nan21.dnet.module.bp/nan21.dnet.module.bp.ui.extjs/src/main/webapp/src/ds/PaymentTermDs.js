 
   	 
Ext.ns("net.nan21.dnet.module.bp.base.ds.model");
	net.nan21.dnet.module.bp.base.ds.model.PaymentTermDs = [
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
	net.nan21.dnet.module.bp.base.ds.param.PaymentTermDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.base.ds");	
	net.nan21.dnet.module.bp.base.ds.PaymentTermDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PaymentTermDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.base.ds.model.PaymentTermDs
				,paramFields: net.nan21.dnet.module.bp.base.ds.param.PaymentTermDsParam				 
			});
		 	net.nan21.dnet.module.bp.base.ds.PaymentTermDs.superclass.constructor.call(this, config);
		}	 
	});  
 