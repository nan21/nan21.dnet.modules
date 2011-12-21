 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.BpBankAccountDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"bpartnerId",type:"int", useNull:true },
		{name:"bpartnerCode",type:"string" },
		{name:"bankId",type:"int", useNull:true },
		{name:"bankCode",type:"string" },
		{name:"bankBranch",type:"string" },
		{name:"accountNo",type:"string" },
		{name:"ibanAccount",type:"boolean" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currencyCode",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.bp.md.ds.model.BpBankAccountDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Dnet.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"bpartnerId",type:"int", useNull:true },
		{name:"bpartnerCode",type:"string" },
		{name:"bankId",type:"int", useNull:true },
		{name:"bankCode",type:"string" },
		{name:"bankBranch",type:"string" },
		{name:"accountNo",type:"string" },
		{name:"ibanAccount",type:"boolean", useNull:true },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"currencyId",type:"int", useNull:true },
		{name:"currencyCode",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.BpBankAccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 