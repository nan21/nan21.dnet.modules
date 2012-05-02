 
   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.CompanyLegalFormLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"countryId", type:"int", useNull:true}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.CompanyLegalFormLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"countryId", type:"int", useNull:true},
		{name:"countryId_From",type:"int", useNull:true},
		{name:"countryId_To",type:"int", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.CompanyLegalFormLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 