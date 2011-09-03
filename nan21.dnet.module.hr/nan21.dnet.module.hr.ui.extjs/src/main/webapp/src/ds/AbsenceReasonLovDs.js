 
   	 
Ext.ns("net.nan21.dnet.module.hr.time.ds.model");
	net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"typeId",type:"int"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds.param");	
	net.nan21.dnet.module.hr.time.ds.param.AbsenceReasonLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds");	
	net.nan21.dnet.module.hr.time.ds.AbsenceReasonLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"AbsenceReasonLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonLovDs
				,paramFields: net.nan21.dnet.module.hr.time.ds.param.AbsenceReasonLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.time.ds.AbsenceReasonLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 