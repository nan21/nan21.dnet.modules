 
   	 
Ext.define("net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"typeId",type:"int", useNull:true }
	]
});
	
Ext.define("net.nan21.dnet.module.hr.time.ds.param.AbsenceReasonLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 