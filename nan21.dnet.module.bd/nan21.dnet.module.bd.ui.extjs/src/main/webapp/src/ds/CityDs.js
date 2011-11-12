 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.CityDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"countryId",type:"int", useNull:true },
		{name:"countryCode",type:"string" },
		{name:"regionId",type:"int", useNull:true },
		{name:"regionCode",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.CityDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"countryId",type:"int", useNull:true },
		{name:"countryCode",type:"string" },
		{name:"regionId",type:"int", useNull:true },
		{name:"regionCode",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.CityDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 