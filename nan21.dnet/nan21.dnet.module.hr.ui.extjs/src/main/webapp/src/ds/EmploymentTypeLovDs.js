 
   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmploymentTypeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 