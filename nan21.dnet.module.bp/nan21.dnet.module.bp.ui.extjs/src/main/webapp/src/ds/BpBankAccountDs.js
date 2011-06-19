 
   	 
Ext.ns("net.nan21.dnet.module.bp.md.ds.model");
	net.nan21.dnet.module.bp.md.ds.model.BpBankAccountDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"bpartnerId",type:"int"}
	,	{name:"bpartnerCode",type:"string"}
	,	{name:"bankId",type:"int"}
	,	{name:"bankCode",type:"string"}
	,	{name:"bankBranch",type:"string"}
	,	{name:"accountNo",type:"string"}
	,	{name:"ibanAccount",type:"boolean"}
	,	{name:"active",type:"boolean"}
	,	{name:"notes",type:"string"}
	,	{name:"currencyId",type:"int"}
	,	{name:"currencyCode",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds.param");	
	net.nan21.dnet.module.bp.md.ds.param.BpBankAccountDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds");	
	net.nan21.dnet.module.bp.md.ds.BpBankAccountDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"BpBankAccountDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.md.ds.model.BpBankAccountDs
				,paramFields: net.nan21.dnet.module.bp.md.ds.param.BpBankAccountDsParam				 
			});
		 	net.nan21.dnet.module.bp.md.ds.BpBankAccountDs.superclass.constructor.call(this, config);
		}	 
	});  
 