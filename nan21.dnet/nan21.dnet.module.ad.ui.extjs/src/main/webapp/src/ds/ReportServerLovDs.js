 
   	 
Ext.define("net.nan21.dnet.module.ad.report.ds.model.ReportServerLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.ad.report.ds.model.ReportServerLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.report.ds.param.ReportServerLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 