/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.bd.attr.ds.model.AttributeSetAttributeDs" ,{
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
		{name:"setId", type:"int", useNull:true},
		{name:"set", type:"string"},
		{name:"attributeId", type:"int", useNull:true},
		{name:"attribute", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"inDescription", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.attr.ds.model.AttributeSetAttributeDsFilter" ,{
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
		{name:"setId", type:"int", useNull:true},
		{name:"setId_From",type:"int", useNull:true},
		{name:"setId_To",type:"int", useNull:true},
		{name:"set", type:"string"},
		{name:"attributeId", type:"int", useNull:true},
		{name:"attributeId_From",type:"int", useNull:true},
		{name:"attributeId_To",type:"int", useNull:true},
		{name:"attribute", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"inDescription", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.attr.ds.param.AttributeSetAttributeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 