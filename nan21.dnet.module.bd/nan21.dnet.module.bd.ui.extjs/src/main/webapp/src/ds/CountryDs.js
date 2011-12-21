 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.CountryDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"iso2",type:"string" },
		{name:"iso3",type:"string" },
		{name:"hasRegions",type:"boolean" },
		{name:"currency",type:"string" },
		{name:"language",type:"string" }
	],
	validations: [  
		{field: "code", type: 'presence'}, 
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.CountryDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"iso2",type:"string" },
		{name:"iso3",type:"string" },
		{name:"hasRegions",type:"boolean", useNull:true },
		{name:"currency",type:"string" },
		{name:"language",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.CountryDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 