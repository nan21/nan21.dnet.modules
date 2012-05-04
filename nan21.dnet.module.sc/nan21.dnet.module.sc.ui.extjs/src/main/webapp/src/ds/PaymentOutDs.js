 
   	 
Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDs" ,{
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
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNo", type:"string"},
		{name:"payToId", type:"int", useNull:true},
		{name:"payTo", type:"string"},
		{name:"payToName", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"fromAccount", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodType", type:"string"},
		{name:"amount", type:"float", useNull:true},
		{name:"confirmed", type:"boolean"},
		{name:"posted", type:"boolean"}
	]
});

Ext.define("net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutDsFilter" ,{
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
		{name:"docDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"docNo", type:"string"},
		{name:"payToId", type:"int", useNull:true},
		{name:"payToId_From",type:"int", useNull:true},
		{name:"payToId_To",type:"int", useNull:true},
		{name:"payTo", type:"string"},
		{name:"payToName", type:"string"},
		{name:"orgId", type:"int", useNull:true},
		{name:"orgId_From",type:"int", useNull:true},
		{name:"orgId_To",type:"int", useNull:true},
		{name:"org", type:"string"},
		{name:"fromAccountId", type:"int", useNull:true},
		{name:"fromAccountId_From",type:"int", useNull:true},
		{name:"fromAccountId_To",type:"int", useNull:true},
		{name:"fromAccount", type:"string"},
		{name:"currencyId", type:"int", useNull:true},
		{name:"currencyId_From",type:"int", useNull:true},
		{name:"currencyId_To",type:"int", useNull:true},
		{name:"currency", type:"string"},
		{name:"paymentMethodId", type:"int", useNull:true},
		{name:"paymentMethodId_From",type:"int", useNull:true},
		{name:"paymentMethodId_To",type:"int", useNull:true},
		{name:"paymentMethod", type:"string"},
		{name:"paymentMethodType", type:"string"},
		{name:"amount", type:"float", useNull:true},
		{name:"amount_From",type:"float", useNull:true},
		{name:"amount_To",type:"float", useNull:true},
		{name:"confirmed", type:"boolean", useNull:true},
		{name:"posted", type:"boolean", useNull:true}
	] 
});
	
Ext.define("net.nan21.dnet.module.sc.invoice.ds.param.PaymentOutDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 