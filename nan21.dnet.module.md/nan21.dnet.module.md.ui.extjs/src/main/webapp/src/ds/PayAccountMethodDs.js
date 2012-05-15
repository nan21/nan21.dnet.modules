/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.org.ds.model.PayAccountMethodDs" ,{
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
		{name:"payAccountId", type:"int", useNull:true},
		{name:"payAccount", type:"string"},
		{name:"payAccountType", type:"string"},
		{name:"payMethodId", type:"int", useNull:true},
		{name:"payMethod", type:"string"},
		{name:"allowPayIn", type:"boolean"},
		{name:"allowPayOut", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.md.org.ds.model.PayAccountMethodDsFilter" ,{
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
		{name:"payAccountId", type:"int", useNull:true},
		{name:"payAccountId_From",type:"int", useNull:true},
		{name:"payAccountId_To",type:"int", useNull:true},
		{name:"payAccount", type:"string"},
		{name:"payAccountType", type:"string"},
		{name:"payMethodId", type:"int", useNull:true},
		{name:"payMethodId_From",type:"int", useNull:true},
		{name:"payMethodId_To",type:"int", useNull:true},
		{name:"payMethod", type:"string"},
		{name:"allowPayIn", type:"boolean", useNull:true},
		{name:"allowPayOut", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.org.ds.param.PayAccountMethodDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 