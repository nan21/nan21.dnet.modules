 
   	 
Ext.define("net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetType",type:"string" },
		{name:"value",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }
	],
	validations: [ 
	]
});

Ext.define("net.nan21.dnet.module.bd.contact.ds.model.CommunicationChannelDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetType",type:"string" },
		{name:"value",type:"string" },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.contact.ds.param.CommunicationChannelDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 