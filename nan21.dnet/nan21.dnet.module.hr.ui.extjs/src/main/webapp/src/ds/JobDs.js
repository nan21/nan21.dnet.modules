 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobDs" ,{
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
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobDsFilter" ,{
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
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.JobDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 