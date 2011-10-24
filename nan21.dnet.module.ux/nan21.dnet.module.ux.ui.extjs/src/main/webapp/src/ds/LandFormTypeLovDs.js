 
   	 
Ext.define("net.nan21.dnet.module.ux.example.ds.model.LandFormTypeLovDs" , {
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
	
Ext.define("net.nan21.dnet.module.ux.example.ds.param.LandFormTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 