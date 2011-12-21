 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobRequirementDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"jobId",type:"int", useNull:true },
		{name:"requirementId",type:"int", useNull:true },
		{name:"requirement",type:"string" },
		{name:"notes",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobRequirementDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"jobId",type:"int", useNull:true },
		{name:"requirementId",type:"int", useNull:true },
		{name:"requirement",type:"string" },
		{name:"notes",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.JobRequirementDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 