 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDs" ,{
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
		{name:"virtualEntity", type:"boolean"},
		{name:"legalEntity", type:"boolean"},
		{name:"accountingEnabled", type:"boolean"},
		{name:"inventory", type:"boolean"},
		{name:"external", type:"boolean"},
		{name:"carrier", type:"boolean"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDsFilter" ,{
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
		{name:"virtualEntity", type:"boolean", useNull:true},
		{name:"legalEntity", type:"boolean", useNull:true},
		{name:"accountingEnabled", type:"boolean", useNull:true},
		{name:"inventory", type:"boolean", useNull:true},
		{name:"external", type:"boolean", useNull:true},
		{name:"carrier", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.OrganizationTypeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 