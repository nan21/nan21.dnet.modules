/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountDs" ,{
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
		{name:"groupId", type:"int", useNull:true},
		{name:"groupCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"analiticSegment", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductAccountDsFilter" ,{
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
		{name:"groupId", type:"int", useNull:true},
		{name:"groupId_From",type:"int", useNull:true},
		{name:"groupId_To",type:"int", useNull:true},
		{name:"groupCode", type:"string"},
		{name:"productId", type:"int", useNull:true},
		{name:"productId_From",type:"int", useNull:true},
		{name:"productId_To",type:"int", useNull:true},
		{name:"productCode", type:"string"},
		{name:"analiticSegment", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductAccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 