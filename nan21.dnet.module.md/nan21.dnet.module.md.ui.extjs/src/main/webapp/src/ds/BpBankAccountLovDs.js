 
   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountLovDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"clientId", type:"int", useNull:true},
		{name:"accountNo", type:"string"}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BpBankAccountLovDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"id", type:"int", useNull:true},
		{name:"accountNo", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.BpBankAccountLovDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 