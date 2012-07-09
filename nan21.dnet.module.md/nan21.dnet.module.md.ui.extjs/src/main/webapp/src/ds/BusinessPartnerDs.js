/*
 * DNet eBusiness Suite
 * Copyright: 2008-2012 Nan21 Electronics SRL. All rights reserved.
 * Use is subject to license terms. 
 */   	 
Ext.define("net.nan21.dnet.module.md.bp.ds.model.BusinessPartnerDs" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean"},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
		{name:"id", type:"int", useNull:true},
		{name:"uuid", type:"string"},
		{name:"clientId", type:"int", useNull:true},
		{name:"createdAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"modifiedAt", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"createdBy", type:"string"},
		{name:"modifiedBy", type:"string"},
		{name:"version", type:"int", useNull:true},
		{name:"entityFQN", type:"string"},
		{name:"type", type:"string"},
		{name:"businessObject", type:"string"},
		{name:"countryId", type:"int", useNull:true},
		{name:"countryCode", type:"string"},
		{name:"taxPayerNo", type:"string"},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"gender", type:"string"},
		{name:"identityCardNo", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"birthDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"companyName", type:"string"},
		{name:"legalFormId", type:"int", useNull:true},
		{name:"legalForm", type:"string"},
		{name:"registrationNo", type:"string"},
		{name:"registrationDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"className", type:"string"}
	],
	validations: [  
		{field: "name", type: 'presence'}
	]
});

Ext.define("net.nan21.dnet.module.md.bp.ds.model.BusinessPartnerDsFilter" ,{
	extend: 'Ext.data.Model',
	fields: [ 
		{name:"name", type:"string"},
		{name:"code", type:"string"},
		{name:"active", type:"boolean", useNull:true},
		{name:"description", type:"string"},
		{name:"notes", type:"string"},
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
		{name:"type", type:"string"},
		{name:"businessObject", type:"string"},
		{name:"countryId", type:"int", useNull:true},
		{name:"countryId_From",type:"int", useNull:true},
		{name:"countryId_To",type:"int", useNull:true},
		{name:"countryCode", type:"string"},
		{name:"taxPayerNo", type:"string"},
		{name:"firstName", type:"string"},
		{name:"lastName", type:"string"},
		{name:"middleName", type:"string"},
		{name:"gender", type:"string"},
		{name:"identityCardNo", type:"string"},
		{name:"passportNo", type:"string"},
		{name:"birthDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"birthDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"companyName", type:"string"},
		{name:"legalFormId", type:"int", useNull:true},
		{name:"legalFormId_From",type:"int", useNull:true},
		{name:"legalFormId_To",type:"int", useNull:true},
		{name:"legalForm", type:"string"},
		{name:"registrationNo", type:"string"},
		{name:"registrationDate", type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"registrationDate_From",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"registrationDate_To",type:"date", dateFormat:Dnet.MODEL_DATE_FORMAT},
		{name:"className", type:"string"}
	] 
});
	
Ext.define("net.nan21.dnet.module.md.bp.ds.param.BusinessPartnerDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 