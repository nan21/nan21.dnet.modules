   

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addDateField({ name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
		.addDateField({ name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
		.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"}) 
		.addChildrenTo("docDate",["docDate_From", "docDate_To"]) 

		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"supplier",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"customer",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.md.mm.price.lovs.PriceListSales", dataIndex:"priceList",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ]  })
		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
		.addTextField({ name:"salesOrderCode", dataIndex:"salesOrderCode",anchor:"-20",maxLength:32  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.tx.lovs.TxDocTypesSI", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethod", dataIndex:"paymentMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentTerm", dataIndex:"paymentTerm",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:300}) 
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"col3", layout:"form", width:180}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["supplier","customer","docType","docDate"])
		.addChildrenTo("col2",["code","currency","priceList","salesOrderCode"])
		.addChildrenTo("col3",["confirmed","posted"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"supplierCode", dataIndex:"supplier",width:100 })   	
		.addTextColumn({ name:"customerCode", dataIndex:"customerCode",width:100 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addTextColumn({ name:"docType", dataIndex:"docType",width:120 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2 })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2 })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",decimals:2 })  
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})   	     
		.addBooleanColumn({ name:"posted", dataIndex:"posted"})   	     
		.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$EditMain",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,noUpdate:true ,allowBlank:false})
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"supplier",anchor:"-20" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"customer",anchor:"-20" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addDisplayFieldText({ name:"currency", dataIndex:"currency", fieldCls:"displayfield important-field"  })
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.md.mm.price.lovs.PriceListSales", dataIndex:"priceList",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ,{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"currency", dsField: "currency"} ]  })
		.addDisplayFieldNumber({name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalAmount", dataIndex:"totalAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed"  })
		.addDisplayFieldBoolean({ name:"posted", dataIndex:"posted"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.tx.lovs.TxDocTypesSI", dataIndex:"docType",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250})     
		.addPanel({ name:"col2", layout:"form" , width:250})     
		.addPanel({ name:"col3", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["supplier","customer","docType","code"])
		.addChildrenTo("col2",["docDate","priceList","currency","confirmed","posted"])
		.addChildrenTo("col3",["totalNetAmount","totalTaxAmount","totalAmount"])
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
 	
 	

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$EditDetails", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$EditDetails",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"salesOrderCode", dataIndex:"salesOrderCode", width:170,noEdit:true  ,maxLength:32  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethod", dataIndex:"paymentMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentTerm", dataIndex:"paymentTerm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		.addLov({ name:"billToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToBill", dataIndex:"billToLocation",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "billToLocationId"} ],filterFieldMapping: [{lovField:"targetUuid", dsField: "customerUuid"} ]  })
		.addLov({ name:"billToContact", xtype:"net.nan21.dnet.module.md.bp.lovs.BpContacts", dataIndex:"billToContact",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "billToContactId"} ],filterFieldMapping: [{lovField:"bpartnerId", dsField: "customerId"} ]  })
		//containers
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"panelBillTo", layout:"form" ,title:"Others", width:350,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"panelPayment", layout:"form" ,title:"Payment", width:350,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"col1"  })      	 
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["panelPayment" ,"panelBillTo" ])
		.addChildrenTo("col2",["salesOrderCode"])
		.addChildrenTo("panelBillTo",["billToLocation","billToContact"])
		.addChildrenTo("panelPayment",["paymentMethod","paymentTerm"])
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
 	
