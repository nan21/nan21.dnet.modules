 
   	 
Ext.ns("net.nan21.dnet.module.hr.grade.ds.model");
	net.nan21.dnet.module.hr.grade.ds.model.GradeLovDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"code",type:"string"}
	,	{name:"name",type:"string"}
	,	{name:"active",type:"boolean"}
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds.param");	
	net.nan21.dnet.module.hr.grade.ds.param.GradeLovDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.grade.ds");	
	net.nan21.dnet.module.hr.grade.ds.GradeLovDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"GradeLovDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.grade.ds.model.GradeLovDs
				,paramFields: net.nan21.dnet.module.hr.grade.ds.param.GradeLovDsParam				 
			});
		 	net.nan21.dnet.module.hr.grade.ds.GradeLovDs.superclass.constructor.call(this, config);
		}	 
	});  
 