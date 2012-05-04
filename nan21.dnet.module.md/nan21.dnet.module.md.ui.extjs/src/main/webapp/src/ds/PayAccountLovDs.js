 
   	 
Ext.define("net.nan21.dnet.module.md.org.ds.model.PayAccountLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"type", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currency", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.org.ds.model.PayAccountLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"type", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currency", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.org.ds.param.PayAccountLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 