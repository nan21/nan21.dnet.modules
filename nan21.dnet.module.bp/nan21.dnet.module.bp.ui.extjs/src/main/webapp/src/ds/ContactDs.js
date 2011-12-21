 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.ContactDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"firstName",type:"string" },
		{name:"lastName",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"gender",type:"string" },
		{name:"birthdate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"position",type:"string" },
		{name:"bpartnerId",type:"int", useNull:true },
		{name:"bpartnerCode",type:"string" },
		{name:"className",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.bp.md.ds.model.ContactDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"firstName",type:"string" },
		{name:"lastName",type:"string" },
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"gender",type:"string" },
		{name:"birthdate",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"position",type:"string" },
		{name:"bpartnerId",type:"int", useNull:true },
		{name:"bpartnerCode",type:"string" },
		{name:"className",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.ContactDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 