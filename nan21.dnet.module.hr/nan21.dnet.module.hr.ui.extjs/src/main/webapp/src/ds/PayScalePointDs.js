 
   	 
Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScalePointDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"payScaleId",type:"int", useNull:true },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"code",type:"string" }
	],
	validations: [  
		{field: "code", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.hr.grade.ds.param.PayScalePointDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 