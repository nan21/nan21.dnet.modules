 
   	 
Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionPlannedLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"projectId", type:"int", useNull:true},
		{name:"planDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	]
});

Ext.define("net.nan21.dnet.module.pj.md.ds.model.ProjectVersionPlannedLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"projectId", type:"int", useNull:true},
		{name:"projectId_From",type:"int", useNull:true},
		{name:"projectId_To",type:"int", useNull:true},
		{name:"planDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"planDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"planDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT}
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.md.ds.param.ProjectVersionPlannedLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 