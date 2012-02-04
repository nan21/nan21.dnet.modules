 
   	 
Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomConversionDs" ,{
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
		{name:"sourceId", type:"int", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"multiplyWith", type:"float", useNull:true},
		{name:"divideTo", type:"float", useNull:true},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomConversionDsFilter" ,{
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
		{name:"sourceId", type:"int", useNull:true},
		{name:"sourceId_From",type:"int", useNull:true},
		{name:"sourceId_To",type:"int", useNull:true},
		{name:"sourceCode", type:"string"},
		{name:"targetId", type:"int", useNull:true},
		{name:"targetId_From",type:"int", useNull:true},
		{name:"targetId_To",type:"int", useNull:true},
		{name:"targetCode", type:"string"},
		{name:"multiplyWith", type:"float", useNull:true},
		{name:"multiplyWith_From",type:"float", useNull:true},
		{name:"multiplyWith_To",type:"float", useNull:true},
		{name:"divideTo", type:"float", useNull:true},
		{name:"divideTo_From",type:"float", useNull:true},
		{name:"divideTo_To",type:"float", useNull:true},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.uom.ds.param.UomConversionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 