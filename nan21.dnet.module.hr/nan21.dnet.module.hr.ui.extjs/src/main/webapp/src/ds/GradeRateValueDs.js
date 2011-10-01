 
   	 
Ext.define("net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"gradeId",type:"int", useNull:true },
		{name:"gradeName",type:"string" },
		{name:"gradeRateId",type:"int", useNull:true },
		{name:"gradeRateName",type:"string" },
		{name:"fixValue",type:"float", useNull:true },
		{name:"minValue",type:"float", useNull:true },
		{name:"maxValue",type:"float", useNull:true },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }
	],
	validations: [ 
	]
});
	
Ext.define("net.nan21.dnet.module.hr.grade.ds.param.GradeRateValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 