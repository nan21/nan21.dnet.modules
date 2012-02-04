 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"assignToUser", type:"string"},
		{name:"assignToGroup", type:"string"},
		{name:"startWithPrevious", type:"boolean"},
		{name:"taskType", type:"string"},
		{name:"processId", type:"int", useNull:true},
		{name:"process", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.WfDefNodeDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
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
		{name:"assignToUser", type:"string"},
		{name:"assignToGroup", type:"string"},
		{name:"startWithPrevious", type:"boolean", useNull:true},
		{name:"taskType", type:"string"},
		{name:"processId", type:"int", useNull:true},
		{name:"processId_From",type:"int", useNull:true},
		{name:"processId_To",type:"int", useNull:true},
		{name:"process", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.WfDefNodeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 