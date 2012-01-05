 
   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.ElementTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 