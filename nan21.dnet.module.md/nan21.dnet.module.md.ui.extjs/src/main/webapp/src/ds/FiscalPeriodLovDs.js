/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"yearId", type:"int", useNull:true},
		{name:"year", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"yearId", type:"int", useNull:true},
		{name:"yearId_From",type:"int", useNull:true},
		{name:"yearId_To",type:"int", useNull:true},
		{name:"year", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.base.period.ds.param.FiscalPeriodLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 