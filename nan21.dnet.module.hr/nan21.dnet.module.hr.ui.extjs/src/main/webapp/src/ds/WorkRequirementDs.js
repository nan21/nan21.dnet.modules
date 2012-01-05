 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.WorkRequirementDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.hr.job.ds.model.WorkRequirementDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.WorkRequirementDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 