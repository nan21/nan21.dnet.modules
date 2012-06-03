/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysJobCtxParamDs" ,{
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
		{name:"jobCtxId", type:"int", useNull:true},
		{name:"jobCtx", type:"string"},
		{name:"jobAlias", type:"string"},
		{name:"jobParamId", type:"int", useNull:true},
		{name:"jobParam", type:"string"},
		{name:"dataType", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.system.ds.model.SysJobCtxParamDsFilter" ,{
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
		{name:"jobCtxId", type:"int", useNull:true},
		{name:"jobCtxId_From",type:"int", useNull:true},
		{name:"jobCtxId_To",type:"int", useNull:true},
		{name:"jobCtx", type:"string"},
		{name:"jobAlias", type:"string"},
		{name:"jobParamId", type:"int", useNull:true},
		{name:"jobParamId_From",type:"int", useNull:true},
		{name:"jobParamId_To",type:"int", useNull:true},
		{name:"jobParam", type:"string"},
		{name:"dataType", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.system.ds.param.SysJobCtxParamDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 