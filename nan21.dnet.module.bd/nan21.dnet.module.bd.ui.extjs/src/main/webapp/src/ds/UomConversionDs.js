 
   	 
Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomConversionDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceId",type:"int", useNull:true },
		{name:"sourceCode",type:"string" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetCode",type:"string" },
		{name:"multiplyWith",type:"float", useNull:true },
		{name:"divideTo",type:"float", useNull:true },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomConversionDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sourceId",type:"int", useNull:true },
		{name:"sourceCode",type:"string" },
		{name:"targetId",type:"int", useNull:true },
		{name:"targetCode",type:"string" },
		{name:"multiplyWith",type:"float", useNull:true },
		{name:"divideTo",type:"float", useNull:true },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.uom.ds.param.UomConversionDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 