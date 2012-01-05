 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"importMapId", type:"int", useNull:true},
		{name:"importMapName", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"dataSource", type:"string"},
		{name:"fileName", type:"string"},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"importMapId", type:"int", useNull:true},
		{name:"importMapId_From",type:"int", useNull:true},
		{name:"importMapId_To",type:"int", useNull:true},
		{name:"importMapName", type:"string"},
		{name:"sequenceNo", type:"int", useNull:true},
		{name:"sequenceNo_From",type:"int", useNull:true},
		{name:"sequenceNo_To",type:"int", useNull:true},
		{name:"dataSource", type:"string"},
		{name:"fileName", type:"string"},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"importFileLocation", type:"string"},
		{name:"importDataSource", type:"string"}
	]
}); 
 