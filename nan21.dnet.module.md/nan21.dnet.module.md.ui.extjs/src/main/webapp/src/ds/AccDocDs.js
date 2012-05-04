 
   	 
Ext.define("net.nan21.dnet.module.md.tx.fin.ds.model.AccDocDs" ,{
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
		{name:"orgId", type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"docNo", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docType", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"crAmount", type:"float", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.tx.fin.ds.model.AccDocDsFilter" ,{
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
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"accSchemaId", type:"int", useNull:true},
		{name:"accSchemaId_From",type:"int", useNull:true},
		{name:"accSchemaId_To",type:"int", useNull:true},
		{name:"accSchema", type:"string"},
		{name:"docNo", type:"string"},
		{name:"docTypeId", type:"int", useNull:true},
		{name:"docTypeId_From",type:"int", useNull:true},
		{name:"docTypeId_To",type:"int", useNull:true},
		{name:"docType", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"dbAmount_From",type:"float", useNull:true},
		{name:"dbAmount_To",type:"float", useNull:true},
		{name:"crAmount", type:"float", useNull:true},
		{name:"crAmount_From",type:"float", useNull:true},
		{name:"crAmount_To",type:"float", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.tx.fin.ds.param.AccDocDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 