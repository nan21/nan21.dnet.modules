 
   	 
Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDs" ,{
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
		{name:"scaleRateId", type:"int", useNull:true},
		{name:"scalePointId", type:"int", useNull:true},
		{name:"scalePointCode", type:"string"},
		{name:"value", type:"float", useNull:true},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.hr.grade.ds.model.PayScaleRateValueDsFilter" ,{
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
		{name:"scaleRateId", type:"int", useNull:true},
		{name:"scaleRateId_From",type:"int", useNull:true},
		{name:"scaleRateId_To",type:"int", useNull:true},
		{name:"scalePointId", type:"int", useNull:true},
		{name:"scalePointId_From",type:"int", useNull:true},
		{name:"scalePointId_To",type:"int", useNull:true},
		{name:"scalePointCode", type:"string"},
		{name:"value", type:"float", useNull:true},
		{name:"value_From",type:"float", useNull:true},
		{name:"value_To",type:"float", useNull:true},
		{name:"validFrom", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validFrom_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"validTo_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.grade.ds.param.PayScaleRateValueDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 