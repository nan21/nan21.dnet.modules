/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectMemberDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"projectId", type:"int", useNull:true},
		{name:"project", type:"string"},
		{name:"projectName", type:"string"},
		{name:"roleId", type:"int", useNull:true},
		{name:"role", type:"string"},
		{name:"memberId", type:"int", useNull:true},
		{name:"member", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectMemberDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
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
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true},
		{name:"project", type:"string"},
		{name:"projectName", type:"string"},
		{name:"roleId", type:"int", useNull:true},
		{name:"roleId_From",type:"int", useNull:true},
		{name:"roleId_To",type:"int", useNull:true},
		{name:"role", type:"string"},
		{name:"memberId", type:"int", useNull:true},
		{name:"memberId_From",type:"int", useNull:true},
		{name:"memberId_To",type:"int", useNull:true},
		{name:"member", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectMemberDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 