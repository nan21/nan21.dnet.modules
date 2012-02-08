 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.DsMethodAccessControlDs" ,{
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
		{name:"dsName", type:"string"},
		{name:"serviceMethod", type:"string"},
		{name:"accessControlId", type:"int", useNull:true},
		{name:"accessControl", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.DsMethodAccessControlDsFilter" ,{
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
		{name:"dsName", type:"string"},
		{name:"serviceMethod", type:"string"},
		{name:"accessControlId", type:"int", useNull:true},
		{name:"accessControlId_From",type:"int", useNull:true},
		{name:"accessControlId_To",type:"int", useNull:true},
		{name:"accessControl", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.DsMethodAccessControlDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 