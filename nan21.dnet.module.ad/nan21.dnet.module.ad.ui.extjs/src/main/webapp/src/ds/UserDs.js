 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.UserDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean"},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"locked", type:"boolean"},
		{name:"accountType", type:"string"},
		{name:"accountTypeId", type:"int", useNull:true},
		{name:"decimalSeparator", type:"string"},
		{name:"thousandSeparator", type:"string"},
		{name:"dateFormatId", type:"int", useNull:true},
		{name:"dateFormat", type:"string"}
	],
	validations: [  
		{field: "code", type: 'presence'}, 
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.UserDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"locked", type:"boolean", useNull:true},
		{name:"accountType", type:"string"},
		{name:"accountTypeId", type:"int", useNull:true},
		{name:"accountTypeId_From",type:"int", useNull:true},
		{name:"accountTypeId_To",type:"int", useNull:true},
		{name:"decimalSeparator", type:"string"},
		{name:"thousandSeparator", type:"string"},
		{name:"dateFormatId", type:"int", useNull:true},
		{name:"dateFormatId_From",type:"int", useNull:true},
		{name:"dateFormatId_To",type:"int", useNull:true},
		{name:"dateFormat", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.UserDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"newPassword", type:"string"},
		{name:"confirmPassword", type:"string"},
		{name:"withRoleId", type:"int", useNull:true},
		{name:"withRole", type:"string"},
		{name:"inGroupId", type:"int", useNull:true},
		{name:"inGroup", type:"string"}
	]
}); 
 