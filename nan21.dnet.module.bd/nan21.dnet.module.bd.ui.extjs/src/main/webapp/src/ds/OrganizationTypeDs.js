 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationTypeDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"virtualEntity",type:"boolean" },
		{name:"legalEntity",type:"boolean" },
		{name:"accountingEnabled",type:"boolean" },
		{name:"inventory",type:"boolean" },
		{name:"external",type:"boolean" },
		{name:"carrier",type:"boolean" }
	],
	validations: [  
		{field: "name", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.OrganizationTypeDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 