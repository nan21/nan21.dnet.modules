 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"regionName",type:"string" },
		{name:"cityName",type:"string" },
		{name:"adress",type:"string" },
		{name:"notes",type:"string" },
		{name:"active",type:"boolean" },
		{name:"countryId",type:"int", useNull:true },
		{name:"countryCode",type:"string" },
		{name:"regionId",type:"int", useNull:true },
		{name:"regionCode",type:"string" },
		{name:"cityId",type:"int", useNull:true },
		{name:"shipping",type:"boolean" },
		{name:"billing",type:"boolean" },
		{name:"mailing",type:"boolean" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetType",type:"string" }
	],
	validations: [ 
	]
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.LocationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 