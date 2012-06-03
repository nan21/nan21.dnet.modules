/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementBalanceLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"engineId", type:"int", useNull:true},
		{name:"engine", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementBalanceLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"engineId", type:"int", useNull:true},
		{name:"engineId_From",type:"int", useNull:true},
		{name:"engineId_To",type:"int", useNull:true},
		{name:"engine", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollElementBalanceLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 