 
   	 
Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomVolumeLovDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" }
	]
});

Ext.define("net.nan21.dnet.module.bd.uom.ds.model.UomVolumeLovDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"code",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.uom.ds.param.UomVolumeLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 