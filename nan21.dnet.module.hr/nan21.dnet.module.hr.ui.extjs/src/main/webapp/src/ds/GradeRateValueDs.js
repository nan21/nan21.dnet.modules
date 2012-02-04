 
   	 
Ext.define("net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"gradeId", type:"int", useNull:true},
		{name:"gradeName", type:"string"},
		{name:"gradeRateId", type:"int", useNull:true},
		{name:"gradeRateName", type:"string"},
		{name:"fixValue", type:"float", useNull:true},
		{name:"minValue", type:"float", useNull:true},
		{name:"maxValue", type:"float", useNull:true},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.hr.grade.ds.model.GradeRateValueDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"gradeId", type:"int", useNull:true},
		{name:"gradeId_From",type:"int", useNull:true},
		{name:"gradeId_To",type:"int", useNull:true},
		{name:"gradeName", type:"string"},
		{name:"gradeRateId", type:"int", useNull:true},
		{name:"gradeRateId_From",type:"int", useNull:true},
		{name:"gradeRateId_To",type:"int", useNull:true},
		{name:"gradeRateName", type:"string"},
		{name:"fixValue", type:"float", useNull:true},
		{name:"fixValue_From",type:"float", useNull:true},
		{name:"fixValue_To",type:"float", useNull:true},
		{name:"minValue", type:"float", useNull:true},
		{name:"minValue_From",type:"float", useNull:true},
		{name:"minValue_To",type:"float", useNull:true},
		{name:"maxValue", type:"float", useNull:true},
		{name:"maxValue_From",type:"float", useNull:true},
		{name:"maxValue_To",type:"float", useNull:true},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.grade.ds.param.GradeRateValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 