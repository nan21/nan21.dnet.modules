   

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDs",
	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderDsFilter",
	paramModel: "net.nan21.dnet.module.sd.order.ds.param.SalesOrderDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesOrder$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addDateField({ name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
		.addDateField({ name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
		.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"}) 
		.addChildrenTo("docDate",["docDate_From", "docDate_To"]) 

		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.bp.base.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"customer",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"supplier",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.mm.price.lovs.PriceListSales", dataIndex:"priceList",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ]  })
		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addBooleanField({ name:"invoiced", dataIndex:"invoiced",anchor:"-20"  })
		.addBooleanField({ name:"delivered", dataIndex:"delivered",anchor:"-20"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.fin.lovs.FinDocTypesSO", dataIndex:"docType",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.bd.fin.lovs.PaymentMethod", dataIndex:"paymentMethod",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.bd.fin.lovs.PaymentTerm", dataIndex:"paymentTerm",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"inventory",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form", width:300}) 
		.addPanel({ name:"col2", layout:"form", width:220}) 
		.addPanel({ name:"col3", layout:"form", width:180}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2","col3"])
		.addChildrenTo("col1",["supplier","customer","warehouse","docType","docDate"])
		.addChildrenTo("col2",["code","currency","priceList","deliveryMethod"])
		.addChildrenTo("col3",["confirmed","invoiced","delivered"])
    	.addAuditFilter({})	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.order.dc.SalesOrder$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"supplierCode", dataIndex:"supplier",width:100 })   	
		.addTextColumn({ name:"inventory", dataIndex:"inventory", hidden:true,width:100 })   	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"currency", dataIndex:"currency", width:70 })   	
		.addTextColumn({ name:"customerCode", dataIndex:"customerCode", hidden:true,width:100 })   	
		.addTextColumn({ name:"customer", dataIndex:"customer",width:200 })   	
		.addTextColumn({ name:"docType", dataIndex:"docType",width:120 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2 })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2 })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",decimals:2 })  
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed", width:70})   	     
		.addBooleanColumn({ name:"invoiced", dataIndex:"invoiced", width:70})   	     
		.addBooleanColumn({ name:"delivered", dataIndex:"delivered", width:70})   	     
		.addTextColumn({ name:"priceList", dataIndex:"priceList",width:120 })   	
		.addTextColumn({ name:"deliveryMethod", dataIndex:"deliveryMethod", hidden:true,width:120 })   	
		.addTextColumn({ name:"billTo", dataIndex:"billTo", hidden:true,width:200 })   	
		.addTextColumn({ name:"billToCode", dataIndex:"billToCode", hidden:true,width:100 })   	
		.addTextColumn({ name:"shipTo", dataIndex:"shipTo", hidden:true,width:200 })   	
		.addTextColumn({ name:"shipToCode", dataIndex:"shipToCode", hidden:true,width:100 })   	
		.addNumberColumn({ name:"supplierId", dataIndex:"supplierId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"billToId", dataIndex:"billToId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"shipToId", dataIndex:"shipToId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"deliveryMethodId", dataIndex:"deliveryMethodId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"priceListId", dataIndex:"priceListId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$EditMain", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesOrder$EditMain",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addLov({ name:"warehouse", xtype:"net.nan21.dnet.module.bd.org.lovs.WarehouseOrganizations", dataIndex:"inventory",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "inventoryId"} ]  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,noUpdate:true ,allowBlank:false})
		.addLov({ name:"priceList", xtype:"net.nan21.dnet.module.mm.price.lovs.PriceListSales", dataIndex:"priceList",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "priceListId"} ,{lovField:"currencyId", dsField: "currencyId"} ,{lovField:"currency", dsField: "currency"} ]  })
		.addDisplayFieldText({ name:"currency", dataIndex:"currency", fieldCls:"displayfield important-field"  })
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"customer",anchor:"-20" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ,{lovField:"id", dsField: "billToId"} ,{lovField:"name", dsField: "billTo"} ,{lovField:"id", dsField: "shipToId"} ,{lovField:"name", dsField: "shipTo"} ]  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"supplier",anchor:"-20" ,noUpdate:true ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addDisplayFieldNumber({name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalAmount", dataIndex:"totalAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldBoolean({ name:"confirmed", dataIndex:"confirmed"  })
		.addLov({ name:"docType", xtype:"net.nan21.dnet.module.bd.fin.lovs.FinDocTypesSO", dataIndex:"docType",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "docTypeId"} ]  })
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
		.addChildrenTo("col1",["supplier","customer","docType","warehouse","code"])
		.addChildrenTo("col2",["docDate","priceList","currency","confirmed"])
		.addChildrenTo("col4",["totalNetAmount","totalTaxAmount","totalAmount"])
;
	}	
	,_beforeApplyStates_: function(record) {	
		
			if (record.get("confirmed") || record.get("invoiced") || record.get("delivered") ) {
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
 	
 	

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrder$EditDetails", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sd.order.dc.SalesOrder$EditDetails",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"plannedDeliveryDate", dataIndex:"plannedDeliveryDate",anchor:"-20" })
		.addTextArea({ name:"deliveryNotes", dataIndex:"deliveryNotes",height:80,anchor:"-20"   })
		.addLov({ name:"paymentMethod", xtype:"net.nan21.dnet.module.bd.fin.lovs.PaymentMethod", dataIndex:"paymentMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]  })
		.addLov({ name:"paymentTerm", xtype:"net.nan21.dnet.module.bd.fin.lovs.PaymentTerm", dataIndex:"paymentTerm",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentTermId"} ]  })
		.addLov({ name:"billTo", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersName", dataIndex:"billTo",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "billToId"} ]  })
		.addLov({ name:"billToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToBill", dataIndex:"billToLocation",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "billToLocationId"} ],filterFieldMapping: [{lovField:"targetUuid", dsField: "billToUuid"} ]  })
		.addLov({ name:"shipTo", xtype:"net.nan21.dnet.module.bp.md.lovs.BusinessPartnersName", dataIndex:"shipTo",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "shipToId"} ]  })
		.addLov({ name:"shipToLocation", xtype:"net.nan21.dnet.module.bd.geo.lovs.LocationsToShip", dataIndex:"shipToLocation",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "shipToLocationId"} ],filterFieldMapping: [{lovField:"targetUuid", dsField: "shipToUuid"} ]  })
		.addLov({ name:"deliveryMethod", xtype:"net.nan21.dnet.module.bp.base.lovs.DeliveryMethods", dataIndex:"deliveryMethod",anchor:"-20" ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "deliveryMethodId"} ]  })
		.addDisplayFieldBoolean({ name:"invoiced", dataIndex:"invoiced"  })
		.addDisplayFieldBoolean({ name:"delivered", dataIndex:"delivered"  })
		//containers
		.addPanel({ name:"panelBilling", layout:"form" ,title:"Invoice", width:400,xtype:"fieldset", border:true, collapsible:true})     
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
		.addChildrenTo("col2",["panelPayment" ,"panelBilling" ])
		.addChildrenTo("panelBilling",["billTo","billToLocation","invoiced"])
		.addChildrenTo("panelShipping",["shipTo","shipToLocation","deliveryMethod","delivered","plannedDeliveryDate","deliveryNotes"])
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
 	
