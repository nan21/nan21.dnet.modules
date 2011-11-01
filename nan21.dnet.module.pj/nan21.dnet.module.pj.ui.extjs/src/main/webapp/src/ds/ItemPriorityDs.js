 
   	 
Ext.define("net.nan21.dnet.module.pj.base.ds.model.ItemPriorityDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean" },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sortValue",type:"int", useNull:true }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "sortValue", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.pj.base.ds.model.ItemPriorityDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"description",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"sortValue",type:"int", useNull:true }
	] 
});
	
Ext.define("net.nan21.dnet.module.pj.base.ds.param.ItemPriorityDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 