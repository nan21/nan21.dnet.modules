 
   	 
Ext.define("net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDs" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean" },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"businessObject",type:"string" },
		{name:"countryId",type:"int", useNull:true },
		{name:"countryCode",type:"string" },
		{name:"taxPayerNo",type:"string" },
		{name:"firstName",type:"string" },
		{name:"lastName",type:"string" },
		{name:"middleName",type:"string" },
		{name:"gender",type:"string" },
		{name:"identityCardNo",type:"string" },
		{name:"passportNo",type:"string" },
		{name:"birthDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"companyName",type:"string" },
		{name:"legalFormId",type:"int", useNull:true },
		{name:"legalForm",type:"string" },
		{name:"registrationNo",type:"string" },
		{name:"registrationDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"className",type:"string" }
	]
});

Ext.define("net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDsFilter" , {
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name",type:"string" },
		{name:"code",type:"string" },
		{name:"active",type:"boolean", useNull:true },
		{name:"notes",type:"string" },
		{name:"id",type:"int", useNull:true },
		{name:"clientId",type:"int", useNull:true },
		{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"createdBy",type:"string" },
		{name:"modifiedBy",type:"string" },
		{name:"version",type:"int", useNull:true },
		{name:"type",type:"string" },
		{name:"businessObject",type:"string" },
		{name:"countryId",type:"int", useNull:true },
		{name:"countryCode",type:"string" },
		{name:"taxPayerNo",type:"string" },
		{name:"firstName",type:"string" },
		{name:"lastName",type:"string" },
		{name:"middleName",type:"string" },
		{name:"gender",type:"string" },
		{name:"identityCardNo",type:"string" },
		{name:"passportNo",type:"string" },
		{name:"birthDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"companyName",type:"string" },
		{name:"legalFormId",type:"int", useNull:true },
		{name:"legalForm",type:"string" },
		{name:"registrationNo",type:"string" },
		{name:"registrationDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"className",type:"string" }
	] 
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.BusinessPartnerDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 