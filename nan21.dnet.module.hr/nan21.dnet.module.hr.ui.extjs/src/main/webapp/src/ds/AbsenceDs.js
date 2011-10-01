 
   	 
Ext.define("net.nan21.dnet.module.hr.time.ds.model.AbsenceDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"employeeId",type:"int", useNull:true },
		{name:"employeeCode",type:"string" },
		{name:"employee",type:"string" },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"reasonId",type:"int", useNull:true },
		{name:"reason",type:"string" },
		{name:"eventDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"hours",type:"int", useNull:true },
		{name:"notes",type:"string" },
		{name:"posted",type:"boolean" }
	],
	validations: [  
		{field: "eventDate", type: 'presence'}, 
		{field: "hours", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.hr.time.ds.param.AbsenceDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 	
		{name:"from",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT},	
		{name:"to",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	]
}); 
 