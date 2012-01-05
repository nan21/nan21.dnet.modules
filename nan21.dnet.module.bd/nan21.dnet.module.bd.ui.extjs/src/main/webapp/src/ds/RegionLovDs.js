 
   	 
Ext.define("net.nan21.dnet.module.bd.geo.ds.model.RegionLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"countryId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.bd.geo.ds.model.RegionLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"code", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"countryId", type:"int", useNull:true},
		{name:"countryId_From",type:"int", useNull:true},
		{name:"countryId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.geo.ds.param.RegionLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 