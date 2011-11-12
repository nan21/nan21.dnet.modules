 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.PositionRequirementDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"positionId",type:"int", useNull:true },
		{name:"requirementId",type:"int", useNull:true },
		{name:"requirement",type:"string" },
		{name:"notes",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.hr.job.ds.model.PositionRequirementDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"positionId",type:"int", useNull:true },
		{name:"requirementId",type:"int", useNull:true },
		{name:"requirement",type:"string" },
		{name:"notes",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.PositionRequirementDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 