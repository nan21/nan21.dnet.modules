 
   	 
Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "code", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.hr.job.ds.model.JobDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"validFrom",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"validTo",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.hr.job.ds.param.JobDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 