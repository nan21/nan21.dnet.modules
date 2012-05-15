/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"name", type:"string"},
		{name:"code", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.hr.employee.ds.model.EmployeeLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"name", type:"string"},
		{name:"code", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.employee.ds.param.EmployeeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 