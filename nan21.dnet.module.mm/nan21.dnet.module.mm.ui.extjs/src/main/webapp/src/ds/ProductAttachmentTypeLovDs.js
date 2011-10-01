 
   	 
Ext.define("net.nan21.dnet.module.mm.md.ds.model.ProductAttachmentTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.mm.md.ds.param.ProductAttachmentTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 