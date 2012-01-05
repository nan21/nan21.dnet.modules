 
   	 
Ext.define("net.nan21.dnet.module.ad.usr.ds.model.AsgnAccessControlDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"dsName", type:"string"},
		{name:"queryAllowed", type:"boolean"},
		{name:"updateAllowed", type:"boolean"},
		{name:"importAllowed", type:"boolean"},
		{name:"exportAllowed", type:"boolean"},
		{name:"accessControlId", type:"int", useNull:true},
		{name:"accessControl", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.usr.ds.model.AsgnAccessControlDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"dsName", type:"string"},
		{name:"queryAllowed", type:"boolean", useNull:true},
		{name:"updateAllowed", type:"boolean", useNull:true},
		{name:"importAllowed", type:"boolean", useNull:true},
		{name:"exportAllowed", type:"boolean", useNull:true},
		{name:"accessControlId", type:"int", useNull:true},
		{name:"accessControlId_From",type:"int", useNull:true},
		{name:"accessControlId_To",type:"int", useNull:true},
		{name:"accessControl", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.usr.ds.param.AsgnAccessControlDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 