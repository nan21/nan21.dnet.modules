/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.hr.training.ds.model.PositionCourseDs" ,{
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
		{name:"positionId", type:"int", useNull:true},
		{name:"positionCode", type:"string"},
		{name:"positionName", type:"string"},
		{name:"courseId", type:"int", useNull:true},
		{name:"courseCode", type:"string"},
		{name:"courseName", type:"string"},
		{name:"mandatory", type:"boolean"},
		{name:"validFor", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.hr.training.ds.model.PositionCourseDsFilter" ,{
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
		{name:"positionId", type:"int", useNull:true},
		{name:"positionId_From",type:"int", useNull:true},
		{name:"positionId_To",type:"int", useNull:true},
		{name:"positionCode", type:"string"},
		{name:"positionName", type:"string"},
		{name:"courseId", type:"int", useNull:true},
		{name:"courseId_From",type:"int", useNull:true},
		{name:"courseId_To",type:"int", useNull:true},
		{name:"courseCode", type:"string"},
		{name:"courseName", type:"string"},
		{name:"mandatory", type:"boolean", useNull:true},
		{name:"validFor", type:"int", useNull:true},
		{name:"validFor_From",type:"int", useNull:true},
		{name:"validFor_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.training.ds.param.PositionCourseDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 