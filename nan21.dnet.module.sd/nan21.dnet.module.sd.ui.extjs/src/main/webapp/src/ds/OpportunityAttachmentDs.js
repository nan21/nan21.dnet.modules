 
   	 
Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityAttachmentDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"category",type:"string" },
		{name:"opportunityId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"location",type:"string" },
		{name:"notes",type:"string" },
		{name:"url",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.sd.opportunity.ds.model.OpportunityAttachmentDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"typeId",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"category",type:"string" },
		{name:"opportunityId",type:"int", useNull:true },
		{name:"name",type:"string" },
		{name:"location",type:"string" },
		{name:"notes",type:"string" },
		{name:"url",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.sd.opportunity.ds.param.OpportunityAttachmentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 