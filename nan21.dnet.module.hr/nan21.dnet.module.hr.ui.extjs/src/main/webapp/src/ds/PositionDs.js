 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.PositionDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean"},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"organizationId", type:"int", useNull:true},
		{name:"organizationCode", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.hr.job.ds.model.PositionDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobId_From",type:"int", useNull:true},
		{name:"jobId_To",type:"int", useNull:true},
		{name:"jobCode", type:"string"},
		{name:"organizationId", type:"int", useNull:true},
		{name:"organizationId_From",type:"int", useNull:true},
		{name:"organizationId_To",type:"int", useNull:true},
		{name:"organizationCode", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.PositionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 