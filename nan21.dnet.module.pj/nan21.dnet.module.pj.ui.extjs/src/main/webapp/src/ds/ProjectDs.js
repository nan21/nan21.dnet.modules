/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"isPublic", type:"boolean"},
		{name:"projectLeadId", type:"int", useNull:true},
		{name:"projectLead", type:"string"}
	],
	validations: [  
		{field: "code", type: 'presence'}, 
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"isPublic", type:"boolean", useNull:true},
		{name:"projectLeadId", type:"int", useNull:true},
		{name:"projectLeadId_From",type:"int", useNull:true},
		{name:"projectLeadId_To",type:"int", useNull:true},
		{name:"projectLead", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 