 
   	 
Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDs" , {
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
		{name:"payScaleId",type:"int", useNull:true },
		{name:"payScaleCode",type:"string" },
		{name:"payScaleName",type:"string" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currencyCode",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"payScaleId",type:"int", useNull:true },
		{name:"payScaleCode",type:"string" },
		{name:"payScaleName",type:"string" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currencyCode",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 