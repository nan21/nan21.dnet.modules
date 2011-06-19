 
   	 
Ext.ns("net.nan21.dnet.module.bp.md.ds.model");
	net.nan21.dnet.module.bp.md.ds.model.BpAccountDs = [
	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"businessPartnerId",type:"int"}
	,	{name:"businessPartner",type:"string"}
	,	{name:"organizationId",type:"int"}
	,	{name:"organization",type:"string"}
	,	{name:"customerGroupId",type:"int"}
	,	{name:"customerGroup",type:"string"}
	,	{name:"customerPaymentMethodId",type:"int"}
	,	{name:"customerPaymentMethod",type:"string"}
	,	{name:"customerCreditLimit",type:"float"}
	,	{name:"customerPaymentTermId",type:"int"}
	,	{name:"customerPaymentTerm",type:"string"}
	,	{name:"vendorGroupId",type:"int"}
	,	{name:"vendorGroup",type:"string"}
	,	{name:"vendorPaymentMethodId",type:"int"}
	,	{name:"vendorPaymentMethod",type:"string"}
	,	{name:"vendorCreditLimit",type:"float"}
	,	{name:"vendorPaymentTermId",type:"int"}
	,	{name:"vendorPaymentTerm",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds.param");	
	net.nan21.dnet.module.bp.md.ds.param.BpAccountDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds");	
	net.nan21.dnet.module.bp.md.ds.BpAccountDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"BpAccountDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.md.ds.model.BpAccountDs
				,paramFields: net.nan21.dnet.module.bp.md.ds.param.BpAccountDsParam				 
			});
		 	net.nan21.dnet.module.bp.md.ds.BpAccountDs.superclass.constructor.call(this, config);
		}	 
	});  
 