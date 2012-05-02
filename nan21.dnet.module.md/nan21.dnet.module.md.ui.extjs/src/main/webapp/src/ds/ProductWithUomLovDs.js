 
   	 
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductWithUomLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"uomId", type:"int", useNull:true},
		{name:"uom", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.mm.prod.ds.model.ProductWithUomLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"uomId", type:"int", useNull:true},
		{name:"uomId_From",type:"int", useNull:true},
		{name:"uomId_To",type:"int", useNull:true},
		{name:"uom", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.mm.prod.ds.param.ProductWithUomLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 