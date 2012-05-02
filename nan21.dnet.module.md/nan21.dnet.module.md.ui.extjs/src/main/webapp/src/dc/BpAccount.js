   

Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.bp.ds.model.BpAccountDs",
	filterModel: "net.nan21.dnet.module.md.bp.ds.model.BpAccountDsFilter",
	paramModel: "net.nan21.dnet.module.md.bp.ds.param.BpAccountDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.bp.dc.BpAccount$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"businessPartner", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersCode", dataIndex:"businessPartner",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "businessPartnerId"} ]  })
		.addLov({ name:"organization", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"organization",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		.addLov({ name:"customerGroup", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomerGroup", dataIndex:"customerGroup",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerGroupId"} ]  })
		.addLov({ name:"vendorGroup", xtype:"net.nan21.dnet.module.md.bp.lovs.VendorGroup", dataIndex:"vendorGroup",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "vendorGroupId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:220}) 
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["organization","businessPartner"])
		.addChildrenTo("col2",["customerGroup","vendorGroup"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.bp.dc.BpAccount$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"organization", dataIndex:"organization",width:100 })   	
		.addTextColumn({ name:"businessPartner", dataIndex:"businessPartner",width:100 })   	
		.addBooleanColumn({ name:"customer", dataIndex:"customer"})   	     
		.addBooleanColumn({ name:"vendor", dataIndex:"vendor"})   	     
		.addTextColumn({ name:"customerGroup", dataIndex:"customerGroup",width:100 })   	
		.addTextColumn({ name:"customerPaymentMethod", dataIndex:"customerPaymentMethod",width:120 })   	
		.addNumberColumn({ name:"customerCreditLimit", dataIndex:"customerCreditLimit", hidden:true,decimals:2 })  
		.addTextColumn({ name:"customerPaymentTerm", dataIndex:"customerPaymentTerm",width:120 })   	
		.addTextColumn({ name:"vendorGroup", dataIndex:"vendorGroup",width:100 })   	
		.addTextColumn({ name:"vendorPaymentMethod", dataIndex:"vendorPaymentMethod",width:120 })   	
		.addNumberColumn({ name:"vendorCreditLimit", dataIndex:"vendorCreditLimit",decimals:2 })  
		.addTextColumn({ name:"vendorPaymentTerm", dataIndex:"vendorPaymentTerm",width:120 })   	
		.addNumberColumn({ name:"organizationId", dataIndex:"organizationId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"businessPartnerId", dataIndex:"businessPartnerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"customerGroupId", dataIndex:"customerGroupId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"vendorGroupId", dataIndex:"vendorGroupId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"customerPaymentMethodId", dataIndex:"customerPaymentMethodId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"vendorPaymentMethodId", dataIndex:"vendorPaymentMethodId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.BpAccount$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCheckbox({ name:"customer", dataIndex:"customer"  })
		.addCheckbox({ name:"vendor", dataIndex:"vendor"  })
		.addLov({ name:"businessPartner", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersCode", dataIndex:"businessPartner",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "businessPartnerId"} ]  })
		.addLov({ name:"organization", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"organization",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		.addLov({ name:"customerGroup", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomerGroup", dataIndex:"customerGroup",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerGroupId"} ]  })
		.addLov({ name:"customerPaymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethod", dataIndex:"customerPaymentMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerPaymentMethodId"} ]  })
		.addNumberField({ name:"customerCreditLimit", dataIndex:"customerCreditLimit",anchor:"-20"  , style: "text-align:right;" })
		.addLov({ name:"customerPaymentTerm", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentTerm", dataIndex:"customerPaymentTerm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerPaymentTerm"} ]  })
		.addLov({ name:"vendorGroup", xtype:"net.nan21.dnet.module.md.bp.lovs.VendorGroup", dataIndex:"vendorGroup",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "vendorGroupId"} ]  })
		.addLov({ name:"vendorPaymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethod", dataIndex:"vendorPaymentMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "vendorPaymentMethodId"} ]  })
		.addNumberField({ name:"vendorCreditLimit", dataIndex:"vendorCreditLimit",anchor:"-20"  , style: "text-align:right;" })
		.addLov({ name:"vendorPaymentTerm", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentTerm", dataIndex:"vendorPaymentTerm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "vendorPaymentTerm"} ]  })
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",anchor:"-20",noEdit:true, hideTrigger:true })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",noEdit:true  ,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"col3", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["organization","businessPartner","customer","vendor"])
		.addChildrenTo("col2",["customerGroup","customerPaymentMethod","customerCreditLimit","customerPaymentTerm"])
		.addChildrenTo("col3",["vendorGroup","vendorPaymentMethod","vendorCreditLimit","vendorPaymentTerm"])
;
	}	
});
 	
 	

Ext.define("net.nan21.dnet.module.md.bp.dc.BpAccount$EditCtx", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.md.bp.dc.BpAccount$EditCtx",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCheckbox({ name:"customer", dataIndex:"customer"  })
		.addCheckbox({ name:"vendor", dataIndex:"vendor"  })
		.addLov({ name:"organization", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"organization",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "organizationId"} ]  })
		.addLov({ name:"customerGroup", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomerGroup", dataIndex:"customerGroup",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerGroupId"} ]  })
		.addLov({ name:"customerPaymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethod", dataIndex:"customerPaymentMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerPaymentMethodId"} ]  })
		.addNumberField({ name:"customerCreditLimit", dataIndex:"customerCreditLimit",anchor:"-20"  , style: "text-align:right;" })
		.addLov({ name:"customerPaymentTerm", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentTerm", dataIndex:"customerPaymentTerm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerPaymentTerm"} ]  })
		.addLov({ name:"vendorGroup", xtype:"net.nan21.dnet.module.md.bp.lovs.VendorGroup", dataIndex:"vendorGroup",anchor:"-20" ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "vendorGroupId"} ]  })
		.addLov({ name:"vendorPaymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethod", dataIndex:"vendorPaymentMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "vendorPaymentMethodId"} ]  })
		.addNumberField({ name:"vendorCreditLimit", dataIndex:"vendorCreditLimit",anchor:"-20"  , style: "text-align:right;" })
		.addLov({ name:"vendorPaymentTerm", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentTerm", dataIndex:"vendorPaymentTerm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "vendorPaymentTerm"} ]  })
		.addDateField({ name:"modifiedAt", dataIndex:"modifiedAt",anchor:"-20",noEdit:true, hideTrigger:true })
		.addTextField({ name:"modifiedBy", dataIndex:"modifiedBy",anchor:"-20",noEdit:true  ,maxLength:32  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"col3", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["organization","customer","vendor"])
		.addChildrenTo("col2",["customerGroup","customerPaymentMethod","customerCreditLimit","customerPaymentTerm"])
		.addChildrenTo("col3",["vendorGroup","vendorPaymentMethod","vendorCreditLimit","vendorPaymentTerm"])
;
	}	
});
 	
