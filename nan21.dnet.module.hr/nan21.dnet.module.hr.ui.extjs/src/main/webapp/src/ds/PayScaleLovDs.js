 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.PayScaleLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.PayScaleLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.PayScaleLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"PayScaleLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.PayScaleLovDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.PayScaleLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.PayScaleLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 