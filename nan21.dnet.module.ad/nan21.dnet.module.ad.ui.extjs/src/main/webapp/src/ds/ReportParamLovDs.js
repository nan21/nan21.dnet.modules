 
   	 
Ext.define("net.nan21.dnet.module.ad.report.ds.model.ReportParamLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"code",type:"string" }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }, 		
		{name:"reportId",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.ad.report.ds.param.ReportParamLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 