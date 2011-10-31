 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"summary",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ItemLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"summary",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ItemLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 