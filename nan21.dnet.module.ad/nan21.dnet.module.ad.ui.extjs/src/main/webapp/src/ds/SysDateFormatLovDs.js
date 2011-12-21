 
   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDateFormatLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysDateFormatLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysDateFormatLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 