 
   	 
Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetType",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"name",type:"string" },
		{name:"location",type:"string" },
		{name:"notes",type:"string" },
		{name:"url",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetType",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"name",type:"string" },
		{name:"location",type:"string" },
		{name:"notes",type:"string" },
		{name:"url",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.data.ds.param.AttachmentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 