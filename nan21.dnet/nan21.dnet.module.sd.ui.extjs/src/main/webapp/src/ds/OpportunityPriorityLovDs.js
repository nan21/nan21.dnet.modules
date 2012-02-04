 
   	 
Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityPriorityLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityPriorityLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.opportunity.ds.param.OpportunityPriorityLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 