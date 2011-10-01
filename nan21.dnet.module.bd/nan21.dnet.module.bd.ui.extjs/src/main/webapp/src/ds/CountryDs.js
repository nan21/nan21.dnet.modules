 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.CountryDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
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
		{field: "name", type: 'presence'}, 
		{field: "code", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.CountryDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 