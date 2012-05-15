/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"string"},
		{name:"name", type:"string"},
		{name:"deployTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fullName", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.workflow.ds.model.ActDeploymentDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"string"},
		{name:"name", type:"string"},
		{name:"deployTime", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deployTime_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"deployTime_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"fullName", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.workflow.ds.param.ActDeploymentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"from", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"to", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
}); 
 