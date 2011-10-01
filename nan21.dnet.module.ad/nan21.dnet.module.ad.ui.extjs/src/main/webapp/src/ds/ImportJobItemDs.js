 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ImportJobItemDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"active",type:"boolean" },
		{name:"jobId",type:"int", useNull:true },
		{name:"jobName",type:"string" },
		{name:"mapId",type:"int", useNull:true },
		{name:"mapName",type:"string" }
	],
	validations: [  
		{field: "sequenceNo", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.ImportJobItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 