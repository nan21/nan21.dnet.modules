 
   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 