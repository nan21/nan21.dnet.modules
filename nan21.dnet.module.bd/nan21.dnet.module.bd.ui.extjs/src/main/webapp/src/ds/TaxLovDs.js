/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.bd.fin.ds.model.TaxLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"rate", type:"float", useNull:true},
		{name:"summary", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.fin.ds.model.TaxLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"rate", type:"float", useNull:true},
		{name:"rate_From",type:"float", useNull:true},
		{name:"rate_To",type:"float", useNull:true},
		{name:"summary", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.fin.ds.param.TaxLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 