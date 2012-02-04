 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.CityDs" ,{
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
		{name:"countryId", type:"int", useNull:true},
		{name:"countryCode", type:"string"},
		{name:"regionId", type:"int", useNull:true},
		{name:"regionCode", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.CityDsFilter" ,{
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
		{name:"countryId", type:"int", useNull:true},
		{name:"countryId_From",type:"int", useNull:true},
		{name:"countryId_To",type:"int", useNull:true},
		{name:"countryCode", type:"string"},
		{name:"regionId", type:"int", useNull:true},
		{name:"regionId_From",type:"int", useNull:true},
		{name:"regionId_To",type:"int", useNull:true},
		{name:"regionCode", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.CityDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 