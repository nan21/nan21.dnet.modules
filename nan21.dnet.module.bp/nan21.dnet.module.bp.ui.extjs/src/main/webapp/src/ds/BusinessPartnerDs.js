 
   	 
Ext.ns("net.nan21.dnet.module.bp.md.ds.model");
	net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDs = [
	{name:"name",type:"string"}
	,	{name:"code",type:"string"}
	,	{name:"active",type:"boolean"}
	,	{name:"notes",type:"string"}
	,	{name:"id",type:"int"}
	,	{name:"clientId",type:"int"}
	,	{name:"createdAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"modifiedAt",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"createdBy",type:"string"}
	,	{name:"modifiedBy",type:"string"}
	,	{name:"version",type:"int"}
	,	{name:"type",type:"string"}
	,	{name:"firstName",type:"string"}
	,	{name:"lastName",type:"string"}
	,	{name:"gender",type:"string"}
	,	{name:"legalForm",type:"string"}
	,	{name:"registrationNo",type:"string"}
	,	{name:"registrationDate",type:"date" ,dateFormat:Ext.MODEL_DATE_FORMAT}
	,	{name:"taxNo",type:"string"}
	,	{name:"name1",type:"string"}
	,	{name:"name2",type:"string"}
	,	{name:"countryId",type:"int"}
	,	{name:"countryCode",type:"string"}
	,	{name:"className",type:"string"}
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds.param");	
	net.nan21.dnet.module.bp.md.ds.param.BusinessPartnerDsParam = [
	
	];
Ext.ns("net.nan21.dnet.module.bp.md.ds");	
	net.nan21.dnet.module.bp.md.ds.BusinessPartnerDs  = Ext.extend(dnet.base.AbstractDs, {
		constructor: function(config) {
			config = config || {};
			Ext.apply(config, {
				 dsName:"BusinessPartnerDs" 				 		
				,recordFields: net.nan21.dnet.module.bp.md.ds.model.BusinessPartnerDs
				,paramFields: net.nan21.dnet.module.bp.md.ds.param.BusinessPartnerDsParam				 
			});
		 	net.nan21.dnet.module.bp.md.ds.BusinessPartnerDs.superclass.constructor.call(this, config);
		}	 
	});  
 