/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.bd.elem.ds.model.ElementSetElementDs" ,{
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
		{name:"elementSetId", type:"int", useNull:true},
		{name:"elementSet", type:"string"},
		{name:"engineId", type:"int", useNull:true},
		{name:"engine", type:"string"},
		{name:"engineType", type:"string"},
		{name:"elementId", type:"int", useNull:true},
		{name:"element", type:"string"},
		{name:"elementName", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"printLabel", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.elem.ds.model.ElementSetElementDsFilter" ,{
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
		{name:"elementSetId", type:"int", useNull:true},
		{name:"elementSetId_From",type:"int", useNull:true},
		{name:"elementSetId_To",type:"int", useNull:true},
		{name:"elementSet", type:"string"},
		{name:"engineId", type:"int", useNull:true},
		{name:"engineId_From",type:"int", useNull:true},
		{name:"engineId_To",type:"int", useNull:true},
		{name:"engine", type:"string"},
		{name:"engineType", type:"string"},
		{name:"elementId", type:"int", useNull:true},
		{name:"elementId_From",type:"int", useNull:true},
		{name:"elementId_To",type:"int", useNull:true},
		{name:"element", type:"string"},
		{name:"elementName", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"printLabel", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.elem.ds.param.ElementSetElementDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 