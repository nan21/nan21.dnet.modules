/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.tx.fin.ds.model.AccOperationDs" ,{
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
		{name:"periodId", type:"int", useNull:true},
		{name:"period", type:"string"},
		{name:"docNo", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartner", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dbAccount", type:"string"},
		{name:"crAccount", type:"string"},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"crAmount", type:"float", useNull:true},
		{name:"notes", type:"string"},
		{name:"accDocLineId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.tx.fin.ds.model.AccOperationDsFilter" ,{
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
		{name:"periodId", type:"int", useNull:true},
		{name:"periodId_From",type:"int", useNull:true},
		{name:"periodId_To",type:"int", useNull:true},
		{name:"period", type:"string"},
		{name:"docNo", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerId_From",type:"int", useNull:true},
		{name:"bpartnerId_To",type:"int", useNull:true},
		{name:"bpartner", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"dbAccount", type:"string"},
		{name:"crAccount", type:"string"},
		{name:"dbAmount", type:"float", useNull:true},
		{name:"dbAmount_From",type:"float", useNull:true},
		{name:"dbAmount_To",type:"float", useNull:true},
		{name:"crAmount", type:"float", useNull:true},
		{name:"crAmount_From",type:"float", useNull:true},
		{name:"crAmount_To",type:"float", useNull:true},
		{name:"notes", type:"string"},
		{name:"accDocLineId", type:"int", useNull:true},
		{name:"accDocLineId_From",type:"int", useNull:true},
		{name:"accDocLineId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.tx.fin.ds.param.AccOperationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 