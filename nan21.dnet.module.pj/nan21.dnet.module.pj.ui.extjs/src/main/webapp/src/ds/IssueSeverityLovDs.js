 
   	 
Ext.define("net.nan21.dnet.module.pj.base.ds.model.IssueSeverityLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"sequenceNo",type:"int", useNull:true }
	]
});

Ext.define("net.nan21.dnet.module.pj.base.ds.model.IssueSeverityLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"sequenceNo",type:"int", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.base.ds.param.IssueSeverityLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 