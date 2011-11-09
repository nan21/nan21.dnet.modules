 
   	 
Ext.define("net.nan21.dnet.module.pj.base.ds.model.ItemPriorityLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"sequenceNo",type:"int", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.pj.base.ds.model.ItemPriorityLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"sequenceNo",type:"int", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.base.ds.param.ItemPriorityLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 