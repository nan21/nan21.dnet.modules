 
   	 
Ext.define("net.nan21.dnet.module.bd.standards.ds.model.ClassificationSystemDs" , {
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
		{name:"internal",type:"boolean" },
		{name:"tag",type:"string" },
		{name:"useInContext",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "code", type: 'presence'}, 
		{field: "useInContext", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.bd.standards.ds.model.ClassificationSystemDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"internal",type:"boolean", useNull:true },
		{name:"tag",type:"string" },
		{name:"useInContext",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.standards.ds.param.ClassificationSystemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 