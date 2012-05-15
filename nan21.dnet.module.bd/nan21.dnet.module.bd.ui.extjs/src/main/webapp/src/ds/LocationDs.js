/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationDs" ,{
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
		{name:"regionName", type:"string"},
		{name:"cityName", type:"string"},
		{name:"adress", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean"},
		{name:"countryId", type:"int", useNull:true},
		{name:"countryCode", type:"string"},
		{name:"regionId", type:"int", useNull:true},
		{name:"regionCode", type:"string"},
		{name:"cityId", type:"int", useNull:true},
		{name:"shipping", type:"boolean"},
		{name:"billing", type:"boolean"},
		{name:"mailing", type:"boolean"},
		{name:"targetUuid", type:"string"},
		{name:"targetType", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.LocationDsFilter" ,{
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
		{name:"regionName", type:"string"},
		{name:"cityName", type:"string"},
		{name:"adress", type:"string"},
		{name:"notes", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"countryId", type:"int", useNull:true},
		{name:"countryId_From",type:"int", useNull:true},
		{name:"countryId_To",type:"int", useNull:true},
		{name:"countryCode", type:"string"},
		{name:"regionId", type:"int", useNull:true},
		{name:"regionId_From",type:"int", useNull:true},
		{name:"regionId_To",type:"int", useNull:true},
		{name:"regionCode", type:"string"},
		{name:"cityId", type:"int", useNull:true},
		{name:"cityId_From",type:"int", useNull:true},
		{name:"cityId_To",type:"int", useNull:true},
		{name:"shipping", type:"boolean", useNull:true},
		{name:"billing", type:"boolean", useNull:true},
		{name:"mailing", type:"boolean", useNull:true},
		{name:"targetUuid", type:"string"},
		{name:"targetType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.LocationDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 