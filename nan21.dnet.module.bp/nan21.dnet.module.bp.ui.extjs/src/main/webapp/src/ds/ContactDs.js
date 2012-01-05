 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.ContactDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean"},
		{name:"gender", type:"string"},
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"position", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerCode", type:"string"},
		{name:"className", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.bp.md.ds.model.ContactDsFilter" ,{
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
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"name", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"gender", type:"string"},
		{name:"birthdate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthdate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthdate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"position", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerId_From",type:"int", useNull:true},
		{name:"bpartnerId_To",type:"int", useNull:true},
		{name:"bpartnerCode", type:"string"},
		{name:"className", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.ContactDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 