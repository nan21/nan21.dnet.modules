/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.time.ds.model.AbsenceDs" ,{
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
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeCode", type:"string"},
		{name:"employee", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"reasonId", type:"int", useNull:true},
		{name:"reason", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"hours", type:"int", useNull:true},
		{name:"notes", type:"string"},
		{name:"posted", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.hr.time.ds.model.AbsenceDsFilter" ,{
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
		{name:"employeeId", type:"int", useNull:true},
		{name:"employeeId_From",type:"int", useNull:true},
		{name:"employeeId_To",type:"int", useNull:true},
		{name:"employeeCode", type:"string"},
		{name:"employee", type:"string"},
		{name:"typeId", type:"int", useNull:true},
		{name:"typeId_From",type:"int", useNull:true},
		{name:"typeId_To",type:"int", useNull:true},
		{name:"type", type:"string"},
		{name:"reasonId", type:"int", useNull:true},
		{name:"reasonId_From",type:"int", useNull:true},
		{name:"reasonId_To",type:"int", useNull:true},
		{name:"reason", type:"string"},
		{name:"eventDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"eventDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"hours", type:"int", useNull:true},
		{name:"hours_From",type:"int", useNull:true},
		{name:"hours_To",type:"int", useNull:true},
		{name:"notes", type:"string"},
		{name:"posted", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.time.ds.param.AbsenceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"from", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"to", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
}); 
 