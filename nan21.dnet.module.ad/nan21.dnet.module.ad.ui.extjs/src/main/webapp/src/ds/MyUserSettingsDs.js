 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MyUserSettingsDs" , {
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
		{name:"decimalSeparator",type:"string" },
		{name:"thousandSeparator",type:"string" },
		{name:"dateFormatId",type:"int", useNull:true },
		{name:"dateFormat",type:"string" }
	],
	validations: [  
		{field: "code", type: 'presence'}, 
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.MyUserSettingsDsFilter" , {
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
		{name:"decimalSeparator",type:"string" },
		{name:"thousandSeparator",type:"string" },
		{name:"dateFormatId",type:"int", useNull:true },
		{name:"dateFormat",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.MyUserSettingsDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 