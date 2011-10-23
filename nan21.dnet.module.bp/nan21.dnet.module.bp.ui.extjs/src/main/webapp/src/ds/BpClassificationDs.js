 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.BpClassificationDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"businessPartnerId",type:"int", useNull:true },
		{name:"businessPartner",type:"string" },
		{name:"businessPartnerType",type:"string" },
		{name:"classificationSystemId",type:"int", useNull:true },
		{name:"classificationSystem",type:"string" },
		{name:"classificationId",type:"int", useNull:true },
		{name:"classificationCode",type:"string" },
		{name:"classificationName",type:"string" }
	],
	validations: [ 
	]
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.BpClassificationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 