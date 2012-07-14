   

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrder$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addTextField({ name:"docNo", dataIndex:"docNo",anchor:"-20",maxLength:255  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.md.bp.lovs.BusinessPartnersName", dataIndex:"supplier",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"customer",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.md.base.tx.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.md.mm.price.lovs.PriceListPurchase", dataIndex:"priceList",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesPO", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethod", dataIndex:"paymentMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentTerm", dataIndex:"paymentTerm",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"inventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
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
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"col3", layout:"form", width:300}) 
		.addPanel({ name:"col4", layout:"form", width:170}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3","col4"])
		.addChildrenTo("col1",["customer","supplier","warehouse","docType","deliveryMethod"])
		.addChildrenTo("col2",["code","priceList","currency"])
		.addChildrenTo("col3",["docDate","totalAmount","totalNetAmount"])
		.addChildrenTo("col4",["confirmed"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrder$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"customer", dataIndex:"customer",width:100 })   	
		.addTextColumn({ name:"inventory", dataIndex:"inventory", hidden:true,width:100 })   	
		.addTextColumn({ name:"code", dataIndex:"code", width:80 })   	
		.addTextColumn({ name:"docNo", dataIndex:"docNo", width:80 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"currency", dataIndex:"currency", width:70 })   	
		.addTextColumn({ name:"supplierCode", dataIndex:"supplier", hidden:true,width:200 })   	
		.addTextColumn({ name:"supplier", dataIndex:"supplier",width:200 })   	
		.addTextColumn({ name:"docType", dataIndex:"docType",width:120 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2 })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2 })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",decimals:2 })  
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})   	     
		.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true,width:120 })   	
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrder$EditMain",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDisplayFieldText({ name:"code", dataIndex:"code"  })
		.addTextField({ name:"docNo", dataIndex:"docNo" ,maxLength:255  })
		.addDateField({ name:"docDate", dataIndex:"docDate" ,allowBlank:false})
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.md.base.tx.lovs.TxDocTypesPO", dataIndex:"docType" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addDisplayFieldText({ name:"currency", dataIndex:"currency", fieldCls:"displayfield important-field"  })
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.md.mm.price.lovs.PriceListPurchase", dataIndex:"priceList" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ,{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"currency", dsField: "currency"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"customer" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.md.bp.lovs.VendorsName", dataIndex:"supplier" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"bpartnerId", dsField: "supplierId"} ,{lovField:"code", dsField: "supplierCode"} ],filterFieldMapping: [{lovField:"orgId", dsField: "customerId"} ]  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"inventory" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
		.addDisplayFieldNumber({name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalAmount", dataIndex:"totalAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed"  })
		.addDateField({ name:"plannedDeliveryDate", dataIndex:"plannedDeliveryDate" })
		.addTextArea({ name:"deliveryNotes", dataIndex:"deliveryNotes",height:80   })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col3", layout:"form" ,width:250})     
		.addPanel({ name:"col4", layout:"form" , width:180})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ,"col4" ])
		.addChildrenTo("col1",["customer","supplier","docType","warehouse","priceList"])
		.addChildrenTo("col2",["docDate","docNo","code","currency"])
		.addChildrenTo("col3",["totalNetAmount","totalTaxAmount","totalAmount"])
		.addChildrenTo("col4",["confirmed"])
;
	}	
	,_beforeApplyStates_: function(record) {	
		
			if (record.get("confirmed")   ) {
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
 	
 	

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrder$EditDetails", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrder$EditDetails",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextArea({ name:"description", dataIndex:"description",height:60   })
		.addDateField({ name:"plannedDeliveryDate", dataIndex:"plannedDeliveryDate" })
		.addTextArea({ name:"deliveryNotes", dataIndex:"deliveryNotes",height:80   })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethodOut", dataIndex:"paymentMethod" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentTerm", dataIndex:"paymentTerm" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.md.base.tx.lovs.DeliveryMethods", dataIndex:"deliveryMethod" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		//containers
		.addPanel({ name:"col3", layout:"form" , width:400})     
		.addPanel({ name:"panelShipping", layout:"form" ,title:"Delivery", width:400,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"panelPayment", layout:"form" ,title:"Payment", width:400,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"col1"  })      	 
		.addPanel({ name:"col2"  })      	 
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["panelShipping" ])
		.addChildrenTo("col2",["panelPayment" ])
		.addChildrenTo("col3",["description"])
		.addChildrenTo("panelShipping",["deliveryMethod","plannedDeliveryDate","deliveryNotes"])
		.addChildrenTo("panelPayment",["paymentMethod","paymentTerm"])
;
	}	
	,_afterApplyStates_: function(record) {	
		
		if ( record.get("invoiced") ) {
			this._disableFields_(["billTo","billToLocation" ]);
		}
		if ( record.get("delivered") ) {
			this._disableFields_(["shipTo","shipToLocation" ]);
		}
		
	}
	,_endDefine_: function() {	
		
		this._controller_.on("afterDoServiceSuccess", function(dc, response, name, options) {
		 	this._applyStates_(dc.record);
		 } , this )
	}
});
 	
