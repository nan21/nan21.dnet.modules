 
   	 
Ext.ns("net.nan21.dnet.module.sd.price.ds.model");
	net.nan21.dnet.module.sd.price.ds.model.PriceListLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.sd.price.ds.param");	
	net.nan21.dnet.module.sd.price.ds.param.PriceListLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.sd.price.ds");	
	net.nan21.dnet.module.sd.price.ds.PriceListLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PriceListLovDs" 				 		
				,recordFields: net.nan21.dnet.module.sd.price.ds.model.PriceListLovDs
				,paramFields: net.nan21.dnet.module.sd.price.ds.param.PriceListLovDsParam				 
			});
		 	net.nan21.dnet.module.sd.price.ds.PriceListLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 