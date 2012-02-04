 
   	 
Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunitySourceLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunitySourceLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.opportunity.ds.param.OpportunitySourceLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 