 
   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerCode", type:"string"},
		{name:"bankId", type:"int", useNull:true},
		{name:"bankCode", type:"string"},
		{name:"bankBranch", type:"string"},
		{name:"accountNo", type:"string"},
		{name:"ibanAccount", type:"boolean"},
		{name:"active", type:"boolean"},
		{name:"notes", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyCode", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"entityFQN", type:"string"},
		{name:"bpartnerId", type:"int", useNull:true},
		{name:"bpartnerId_From",type:"int", useNull:true},
		{name:"bpartnerId_To",type:"int", useNull:true},
		{name:"bpartnerCode", type:"string"},
		{name:"bankId", type:"int", useNull:true},
		{name:"bankId_From",type:"int", useNull:true},
		{name:"bankId_To",type:"int", useNull:true},
		{name:"bankCode", type:"string"},
		{name:"bankBranch", type:"string"},
		{name:"accountNo", type:"string"},
		{name:"ibanAccount", type:"boolean", useNull:true},
		{name:"active", type:"boolean", useNull:true},
		{name:"notes", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currencyCode", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.BpBankAccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 