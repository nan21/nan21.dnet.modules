 
   	 
Ext.define("net.nan21.dnet.module.ad.impex.ds.model.ImportMapItemDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"importMapId",type:"int", useNull:true },
		{name:"importMapName",type:"string" },
		{name:"sequenceNo",type:"int", useNull:true },
		{name:"dataSource",type:"string" },
		{name:"fileName",type:"string" },
		{name:"active",type:"boolean" }
	],
	validations: [  
		{field: "sequenceNo", type: 'presence'}, 
		{field: "dataSource", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.ad.impex.ds.param.ImportMapItemDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 