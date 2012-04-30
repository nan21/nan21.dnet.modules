   

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
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"supplier",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"customer",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.md.mm.price.lovs.PriceListPurchase", dataIndex:"priceList",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.tx.lovs.TxDocTypesPO", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethod", dataIndex:"paymentMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentTerm", dataIndex:"paymentTerm",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
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
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["customer","supplier","warehouse","docType","deliveryMethod"])
		.addChildrenTo("col2",["code","priceList","currency","confirmed"])
		.addChildrenTo("col3",["docDate","totalAmount","totalNetAmount"])
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
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
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
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"inventory",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,allowBlank:false})
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.md.mm.price.lovs.PriceListPurchase", dataIndex:"priceList",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ,{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"currency", dsField: "currency"} ]  })
		.addDisplayFieldText({ name:"currency", dataIndex:"currency", fieldCls:"displayfield important-field"  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.md.bp.lovs.CustomersName", dataIndex:"supplier",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"customer",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addDisplayFieldNumber({name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalAmount", dataIndex:"totalAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.tx.lovs.TxDocTypesPO", dataIndex:"docType",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed"  })
		.addDateField({ name:"plannedDeliveryDate", dataIndex:"plannedDeliveryDate",anchor:"-20" })
		.addTextArea({ name:"deliveryNotes", dataIndex:"deliveryNotes",height:80,anchor:"-20"   })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250})     
		.addPanel({ name:"col2", layout:"form" ,width:250})     
		.addPanel({ name:"col4", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col4" ])
		.addChildrenTo("col1",["customer","supplier","docType","warehouse","code"])
		.addChildrenTo("col2",["docDate","priceList","currency","confirmed"])
		.addChildrenTo("col4",["totalNetAmount","totalTaxAmount","totalAmount"])
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
		.addDateField({ name:"plannedDeliveryDate", dataIndex:"plannedDeliveryDate",anchor:"-20" })
		.addTextArea({ name:"deliveryNotes", dataIndex:"deliveryNotes",height:80,anchor:"-20"   })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentMethod", dataIndex:"paymentMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.bd.tx.lovs.PaymentTerm", dataIndex:"paymentTerm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.bd.tx.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		//containers
		.addPanel({ name:"panelShipping", layout:"form" ,title:"Delivery", width:400,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"panelPayment", layout:"form" ,title:"Payment", width:400,xtype:"fieldset", border:true, collapsible:true})     
		.addPanel({ name:"col1"  })      	 
		.addPanel({ name:"col2"  })      	 
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["panelShipping" ])
		.addChildrenTo("col2",["panelPayment" ])
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
 	
