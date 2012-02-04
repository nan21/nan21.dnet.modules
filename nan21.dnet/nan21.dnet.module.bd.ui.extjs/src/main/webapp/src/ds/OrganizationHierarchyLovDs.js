 
   	 
Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"active", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"startDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"startDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"endDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"active", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.bd.org.ds.param.OrganizationHierarchyLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 