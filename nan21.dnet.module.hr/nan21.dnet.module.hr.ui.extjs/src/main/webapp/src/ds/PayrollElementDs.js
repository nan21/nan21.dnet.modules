/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDs" ,{
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
		{name:"engineId", type:"int", useNull:true},
		{name:"engine", type:"string"},
		{name:"engineType", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"dataType", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"calculation", type:"string"},
		{name:"balance", type:"boolean"},
		{name:"balanceFunction", type:"string"},
		{name:"sourceElementId", type:"int", useNull:true},
		{name:"sourceElement", type:"string"},
		{name:"accItemId", type:"int", useNull:true},
		{name:"accItem", type:"string"}
	],
	validations: [  
		{field: "code", type: 'presence'}, 
		{field: "name", type: 'presence'}
	]	
	
});

Ext.define("net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementDsFilter" ,{
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
		{name:"engineId", type:"int", useNull:true},
		{name:"engineId_From",type:"int", useNull:true},
		{name:"engineId_To",type:"int", useNull:true},
		{name:"engine", type:"string"},
		{name:"engineType", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"dataType", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"calculation", type:"string"},
		{name:"balance", type:"boolean", useNull:true},
		{name:"balanceFunction", type:"string"},
		{name:"sourceElementId", type:"int", useNull:true},
		{name:"sourceElementId_From",type:"int", useNull:true},
		{name:"sourceElementId_To",type:"int", useNull:true},
		{name:"sourceElement", type:"string"},
		{name:"accItemId", type:"int", useNull:true},
		{name:"accItemId_From",type:"int", useNull:true},
		{name:"accItemId_To",type:"int", useNull:true},
		{name:"accItem", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.payroll.ds.param.PayrollElementDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 