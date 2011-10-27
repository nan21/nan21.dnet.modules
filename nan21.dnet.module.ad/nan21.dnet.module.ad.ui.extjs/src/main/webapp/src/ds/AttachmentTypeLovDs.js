 
   	 
Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"useInContext",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "useInContext", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.ad.data.ds.model.AttachmentTypeLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"useInContext",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.data.ds.param.AttachmentTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 