 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.BpAccountDs" , {
	extend: 'Ext.data.Model',
	fields: [  		
		{name:"id",type:"int", useNull:true }, 		
		{name:"clientId",type:"int", useNull:true }, 		
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT }, 		
		{name:"createdBy",type:"string" }, 		
		{name:"modifiedBy",type:"string" }, 		
		{name:"version",type:"int", useNull:true }, 		
		{name:"businessPartnerId",type:"int", useNull:true }, 		
		{name:"businessPartner",type:"string" }, 		
		{name:"organizationId",type:"int", useNull:true }, 		
		{name:"organization",type:"string" }, 		
		{name:"customerGroupId",type:"int", useNull:true }, 		
		{name:"customerGroup",type:"string" }, 		
		{name:"customerPaymentMethodId",type:"int", useNull:true }, 		
		{name:"customerPaymentMethod",type:"string" }, 		
		{name:"customerCreditLimit",type:"float", useNull:true }, 		
		{name:"customerPaymentTermId",type:"int", useNull:true }, 		
		{name:"customerPaymentTerm",type:"string" }, 		
		{name:"vendorGroupId",type:"int", useNull:true }, 		
		{name:"vendorGroup",type:"string" }, 		
		{name:"vendorPaymentMethodId",type:"int", useNull:true }, 		
		{name:"vendorPaymentMethod",type:"string" }, 		
		{name:"vendorCreditLimit",type:"float", useNull:true }, 		
		{name:"vendorPaymentTermId",type:"int", useNull:true }, 		
		{name:"vendorPaymentTerm",type:"string" }
	]
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.BpAccountDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 