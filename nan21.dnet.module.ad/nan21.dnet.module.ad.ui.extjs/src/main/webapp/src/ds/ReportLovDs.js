 
   	 
Ext.define("net.nan21.dnet.module.ad.report.ds.model.ReportLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.report.ds.param.ReportLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 