 
   	 
Ext.ns("net.nan21.dnet.module.hr.time.ds.model");
	net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryDs = [
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
Ext.ns("net.nan21.dnet.module.hr.time.ds.param");	
	net.nan21.dnet.module.hr.time.ds.param.AbsenceCategoryDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.hr.time.ds");	
	net.nan21.dnet.module.hr.time.ds.AbsenceCategoryDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"AbsenceCategoryDs" 				 		
				,recordFields: net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryDs
				,paramFields: net.nan21.dnet.module.hr.time.ds.param.AbsenceCategoryDsParam				 
			});
		 	net.nan21.dnet.module.hr.time.ds.AbsenceCategoryDs.superclass.constructor.call(this, config);
		}	 
	});  
 