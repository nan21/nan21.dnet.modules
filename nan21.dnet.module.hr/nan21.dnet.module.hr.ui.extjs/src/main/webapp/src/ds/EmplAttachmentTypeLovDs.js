 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmplAttachmentTypeLovDs" , {
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
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmplAttachmentTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 