 
   	 
Ext.define("net.nan21.dnet.module.bd.acc.ds.model.AccountDs" ,{
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
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"accGroupId", type:"int", useNull:true},
		{name:"accGroup", type:"string"},
		{name:"sign", type:"string"},
		{name:"summary", type:"boolean"}
	],
	validations: [  
		{field: "code", type: 'presence'}, 
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.bd.acc.ds.model.AccountDsFilter" ,{
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
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"accGroupId", type:"int", useNull:true},
		{name:"accGroupId_From",type:"int", useNull:true},
		{name:"accGroupId_To",type:"int", useNull:true},
		{name:"accGroup", type:"string"},
		{name:"sign", type:"string"},
		{name:"summary", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.acc.ds.param.AccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 