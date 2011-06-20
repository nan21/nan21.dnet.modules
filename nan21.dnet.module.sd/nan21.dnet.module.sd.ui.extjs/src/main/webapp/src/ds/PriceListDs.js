 
   	 
Ext.ns("net.nan21.dnet.module.sd.price.ds.model");
	net.nan21.dnet.module.sd.price.ds.model.PriceListDs = [
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
Ext.ns("net.nan21.dnet.module.sd.price.ds.param");	
	net.nan21.dnet.module.sd.price.ds.param.PriceListDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.price.ds");	
	net.nan21.dnet.module.sd.price.ds.PriceListDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PriceListDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.price.ds.model.PriceListDs
				,paramFields: net.nan21.dnet.module.sd.price.ds.param.PriceListDsParam				 
			});
		 	net.nan21.dnet.module.sd.price.ds.PriceListDs.superclass.constructor.call(this, config);
		}	 
	});  
 