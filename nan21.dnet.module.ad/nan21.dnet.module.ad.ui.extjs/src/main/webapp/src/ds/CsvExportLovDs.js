 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.CsvExportLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.ad.impex.ds.model.CsvExportLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.CsvExportLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 