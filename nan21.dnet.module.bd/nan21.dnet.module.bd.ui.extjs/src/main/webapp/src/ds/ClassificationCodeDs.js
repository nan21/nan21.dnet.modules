 
   	 
Ext.define("net.nan21.dnet.module.bd.standards.ds.model.ClassificationCodeDs" , {
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
		{name:"classSystemId",type:"int", useNull:true },
		{name:"classSystem",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "code", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.bd.standards.ds.model.ClassificationCodeDsFilter" , {
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
		{name:"classSystemId",type:"int", useNull:true },
		{name:"classSystem",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.standards.ds.param.ClassificationCodeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 