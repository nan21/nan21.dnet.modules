 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.BpClassificationDs" ,{
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
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartner", type:"string"},
		{name:"businessPartnerBO", type:"string"},
		{name:"classificationSystemId", type:"int", useNull:true},
		{name:"classificationSystem", type:"string"},
		{name:"classificationId", type:"int", useNull:true},
		{name:"classificationCode", type:"string"},
		{name:"classificationName", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bp.md.ds.model.BpClassificationDsFilter" ,{
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
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartnerId_From",type:"int", useNull:true},
		{name:"businessPartnerId_To",type:"int", useNull:true},
		{name:"businessPartner", type:"string"},
		{name:"businessPartnerBO", type:"string"},
		{name:"classificationSystemId", type:"int", useNull:true},
		{name:"classificationSystemId_From",type:"int", useNull:true},
		{name:"classificationSystemId_To",type:"int", useNull:true},
		{name:"classificationSystem", type:"string"},
		{name:"classificationId", type:"int", useNull:true},
		{name:"classificationId_From",type:"int", useNull:true},
		{name:"classificationId_To",type:"int", useNull:true},
		{name:"classificationCode", type:"string"},
		{name:"classificationName", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.BpClassificationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 