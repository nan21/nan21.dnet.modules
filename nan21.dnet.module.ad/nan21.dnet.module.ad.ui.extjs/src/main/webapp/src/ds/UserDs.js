 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.UserDs" , {
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
		{name:"locked",type:"boolean" },
		{name:"accountType",type:"string" },
		{name:"accountTypeId",type:"int", useNull:true }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "code", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.UserDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 