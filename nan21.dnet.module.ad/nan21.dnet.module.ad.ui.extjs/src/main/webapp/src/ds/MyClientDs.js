/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.client.ds.model.MyClientDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"notes", type:"string"},
		{name:"maintenanceLanguage", type:"string"},
		{name:"adminRole", type:"string"},
		{name:"id", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.ad.client.ds.model.MyClientDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"notes", type:"string"},
		{name:"maintenanceLanguage", type:"string"},
		{name:"adminRole", type:"string"},
		{name:"id", type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.client.ds.param.MyClientDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 