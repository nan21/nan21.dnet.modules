   

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:255  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"customer",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"supplier",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesPI", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethodOut", dataIndex:"paymentMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentTerm", dataIndex:"paymentTerm",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		.addDateField({ name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
		.addDateField({ name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
		.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"}) 
		.addChildrenTo("docDate",["docDate_From", "docDate_To"]) 

		.addNumberField({ name:"totalAmount_From", dataIndex:"totalAmount_From", emptyText:"From" })
		.addNumberField({ name:"totalAmount_To", dataIndex:"totalAmount_To", emptyText:"To" })
		.addFieldContainer({name: "totalAmount", fieldLabel:"Total Amount"})  
		.addChildrenTo("totalAmount",["totalAmount_From", "totalAmount_To"]) 

		.addNumberField({ name:"totalNetAmount_From", dataIndex:"totalNetAmount_From", emptyText:"From" })
		.addNumberField({ name:"totalNetAmount_To", dataIndex:"totalNetAmount_To", emptyText:"To" })
		.addFieldContainer({name: "totalNetAmount", fieldLabel:"Total Net Amount"})  
		.addChildrenTo("totalNetAmount",["totalNetAmount_From", "totalNetAmount_To"]) 

		//containers
		.addPanel({ name:"col1", layout:"form", width:250}) 
		.addPanel({ name:"col2", layout:"form", width:200}) 
		.addPanel({ name:"col3", layout:"form", width:300}) 
		.addPanel({ name:"col4", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["customer","supplier","docType","code"])
		.addChildrenTo("col2",["docNo","currency"])
		.addChildrenTo("col3",["docDate","totalAmount","totalNetAmount"])
		.addChildrenTo("col4",["confirmed","posted"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addTextColumn({ name:"docNo", dataIndex:"docNo", width:70 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"customer", dataIndex:"customer",width:100 })   	
		.addTextColumn({ name:"supplierCode", dataIndex:"supplierCode", hidden:true,width:100 })   	
		.addTextColumn({ name:"supplier", dataIndex:"supplier",width:200 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addTextColumn({ name:"docType", dataIndex:"docType",width:120 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2 })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2 })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",decimals:2 })  
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})   	     
		.addBooleanColumn({ name:"posted", dataIndex:"posted"})   	     
		.addNumberColumn({ name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$EditMain",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"customer" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"supplier" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addDisplayFieldText({ name:"code", dataIndex:"code"  })
		.addTextField({ name:"docNo", dataIndex:"docNo" ,maxLength:255  })
		.addDateField({ name:"docDate", dataIndex:"docDate" ,allowBlank:false})
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesPI", dataIndex:"docType" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addDisplayFieldNumber({name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalAmount", dataIndex:"totalAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed"  })
		.addDisplayFieldBoolean({ name:"posted", dataIndex:"posted"  })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250})     
		.addPanel({ name:"col2", layout:"form" , width:200})     
		.addPanel({ name:"col3", layout:"form" , width:220})     
		.addPanel({ name:"col4", layout:"form" , width:170})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ,"col4" ])
		.addChildrenTo("col1",["customer","supplier","docType","currency"])
		.addChildrenTo("col2",["docDate","docNo","code"])
		.addChildrenTo("col3",["totalNetAmount","totalTaxAmount","totalAmount"])
		.addChildrenTo("col4",["confirmed","posted"])
;
	}	
	,_beforeApplyStates_: function(record) {	
		
			if (record.get("confirmed") || record.get("posted") ) {
				this._disableAllFields_();
				return false;
			}
	}
	,_endDefine_: function() {	
		
			this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
			 	this._applyStates_(dc.record);
			 } , this )
	}
});
 	
 	

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$EditDetails", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$EditDetails",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addCheckbox({ name:"selfPayed", dataIndex:"selfPayed",listeners:{change:{scope:this, fn:this._onSelfPayedChange_}}  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethodOut", dataIndex:"paymentMethod" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentTerm", dataIndex:"paymentTerm" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		.addLov({ name:"fromAccount", xtype:"net.nan21.dnet.module.md.org.lovs.PayAccounts", dataIndex:"fromAccount" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "fromAccountId"} ],filterFieldMapping: [{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"type",value: "cash"} ]  })
		//containers
		.addPanel({ name:"panelPayment", layout:"form" ,title:"Payment", width:350,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"col1"  })      	 
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ])
		.addChildrenTo("col1",["panelPayment" ])
		.addChildrenTo("panelPayment",["selfPayed","fromAccount","paymentMethod","paymentTerm"])
;
	}	
	,_beforeApplyStates_: function(record) {	
		
			if (record.get("confirmed") || record.get("posted") ) {
				this._disableAllFields_();
				return false;
			}
	}
	,_endDefine_: function() {	
		
			this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
			 	this._applyStates_(dc.record);
			 } , this )
	}
	,_onSelfPayedChange_: function() {	
		var r = this._getController_().getRecord();
		if (!r.get("selfPayed")) {			 
            r.set("fromAccountId", "");
            r.set("fromAccount", "");            
		}
		this._doEnableFromAccount_(r.data.selfPayed);
	}
	,_doEnableFromAccount_: function(enable) {	
		if (enable) {
			this._getElement_("fromAccount").enable();
			this._getElement_("paymentMethod").disable();
			this._getElement_("paymentTerm").disable();
		} else {
			this._getElement_("fromAccount").disable();	
			this._getElement_("paymentMethod").enable();
			this._getElement_("paymentTerm").enable();		 
		}
	}
	,_afterBind_: function(record) {	
		if (record) {
			this._doEnableFromAccount_(record.data.selfPayed);
		}
	}
});
 	
