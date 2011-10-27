 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.ContactLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.bp.md.ds.model.ContactLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.ContactLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 