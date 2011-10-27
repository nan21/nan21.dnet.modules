 
   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"string" },
		{name:"name",type:"string" },
		{name:"fullName",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActProcessDefinitionLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"string" },
		{name:"name",type:"string" },
		{name:"fullName",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActProcessDefinitionLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 