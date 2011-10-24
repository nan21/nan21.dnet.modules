 
   	 
Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeDs" , {
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
		{name:"category",type:"string" },
		{name:"uploadPath",type:"string" },
		{name:"baseUrl",type:"string" },
		{name:"useInContext",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "category", type: 'presence'}, 
		{field: "baseUrl", type: 'presence'}, 
		{field: "useInContext", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.ad.data.ds.param.AttachmentTypeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 