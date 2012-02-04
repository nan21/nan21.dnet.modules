 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDs" ,{
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
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"active", type:"boolean"},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobName", type:"string"},
		{name:"mapId", type:"int", useNull:true},
		{name:"mapName", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ExportJobItemDsFilter" ,{
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
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"active", type:"boolean", useNull:true},
		{name:"jobId", type:"int", useNull:true},
		{name:"jobId_From",type:"int", useNull:true},
		{name:"jobId_To",type:"int", useNull:true},
		{name:"jobName", type:"string"},
		{name:"mapId", type:"int", useNull:true},
		{name:"mapId_From",type:"int", useNull:true},
		{name:"mapId_To",type:"int", useNull:true},
		{name:"mapName", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.ExportJobItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 