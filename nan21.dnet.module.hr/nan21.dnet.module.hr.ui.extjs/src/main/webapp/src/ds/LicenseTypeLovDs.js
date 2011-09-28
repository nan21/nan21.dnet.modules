 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.LicenseTypeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"name",type:"string" }, 		
		{name:"active",type:"boolean" }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.LicenseTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 