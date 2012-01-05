 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDateFormatDs" ,{
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
		{name:"extjsDateFormat", type:"string"},
		{name:"extjsTimeFormat", type:"string"},
		{name:"extjsDateTimeFormat", type:"string"},
		{name:"extjsAltFormats", type:"string"},
		{name:"javaDateFormat", type:"string"},
		{name:"javaTimeFormat", type:"string"},
		{name:"javaDateTimeFormat", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDateFormatDsFilter" ,{
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
		{name:"extjsDateFormat", type:"string"},
		{name:"extjsTimeFormat", type:"string"},
		{name:"extjsDateTimeFormat", type:"string"},
		{name:"extjsAltFormats", type:"string"},
		{name:"javaDateFormat", type:"string"},
		{name:"javaTimeFormat", type:"string"},
		{name:"javaDateTimeFormat", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDateFormatDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 