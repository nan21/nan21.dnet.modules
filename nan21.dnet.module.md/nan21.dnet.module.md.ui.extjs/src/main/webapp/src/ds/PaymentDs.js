 
   	 
Ext.define("net.nan21.dnet.module.md.tx.fin.ds.model.PaymentDs" ,{
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
		{name:"code", type:"string"},
		{name:"docNo", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"fromOrgId", type:"int", useNull:true},
		{name:"fromOrg", type:"string"},
		{name:"toOrgId", type:"int", useNull:true},
		{name:"toOrg", type:"string"},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"fromAccount", type:"string"},
		{name:"toAccountId", type:"int", useNull:true},
		{name:"toAccount", type:"string"},
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartner", type:"string"},
		{name:"amount", type:"float", useNull:true},
		{name:"confirmed", type:"boolean"},
		{name:"posted", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.md.tx.fin.ds.model.PaymentDsFilter" ,{
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
		{name:"code", type:"string"},
		{name:"docNo", type:"string"},
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethodId_From",type:"int", useNull:true},
		{name:"paymentMethodId_To",type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"fromOrgId", type:"int", useNull:true},
		{name:"fromOrgId_From",type:"int", useNull:true},
		{name:"fromOrgId_To",type:"int", useNull:true},
		{name:"fromOrg", type:"string"},
		{name:"toOrgId", type:"int", useNull:true},
		{name:"toOrgId_From",type:"int", useNull:true},
		{name:"toOrgId_To",type:"int", useNull:true},
		{name:"toOrg", type:"string"},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"fromAccountId_From",type:"int", useNull:true},
		{name:"fromAccountId_To",type:"int", useNull:true},
		{name:"fromAccount", type:"string"},
		{name:"toAccountId", type:"int", useNull:true},
		{name:"toAccountId_From",type:"int", useNull:true},
		{name:"toAccountId_To",type:"int", useNull:true},
		{name:"toAccount", type:"string"},
		{name:"businessPartnerId", type:"int", useNull:true},
		{name:"businessPartnerId_From",type:"int", useNull:true},
		{name:"businessPartnerId_To",type:"int", useNull:true},
		{name:"businessPartner", type:"string"},
		{name:"amount", type:"float", useNull:true},
		{name:"amount_From",type:"float", useNull:true},
		{name:"amount_To",type:"float", useNull:true},
		{name:"confirmed", type:"boolean", useNull:true},
		{name:"posted", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.tx.fin.ds.param.PaymentDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 