 
   	 
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
		{name:"firstName",type:"string" },
		{name:"lastName",type:"string" },
		{name:"gender",type:"string" },
		{name:"legalForm",type:"string" },
		{name:"registrationNo",type:"string" },
		{name:"registrationDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT },
		{name:"taxNo",type:"string" },
		{name:"name1",type:"string" },
		{name:"name2",type:"string" },
		{name:"countryId",type:"int", useNull:true },
		{name:"countryCode",type:"string" },
		{name:"className",type:"string" }
	],
	validations: [  
		{field: "name", type: 'presence'}, 
		{field: "code", type: 'presence'}
	]
});
	
Ext.define("net.nan21.dnet.module.bp.md.ds.param.BusinessPartnerDsParam", {
	extend: 'Ext.data.Model',
	fields: [ 
	]
}); 
 