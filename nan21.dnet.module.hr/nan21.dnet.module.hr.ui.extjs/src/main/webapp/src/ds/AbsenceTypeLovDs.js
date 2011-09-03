 
   	 
Ext.ns("net.nan21.dnet.module.hr.time.ds.model");
	net.nan21.dnet.module.hr.time.ds.model.AbsenceTypeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds.param");	
	net.nan21.dnet.module.hr.time.ds.param.AbsenceTypeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds");	
	net.nan21.dnet.module.hr.time.ds.AbsenceTypeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"AbsenceTypeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.time.ds.model.AbsenceTypeLovDs
				,paramFields: net.nan21.dnet.module.hr.time.ds.param.AbsenceTypeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.time.ds.AbsenceTypeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 