   

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
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"customer",anchor:"-20",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"supplier",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form", width:250}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["code","docDate","currency"])
		.addChildrenTo("col2",["supplier","customer"])
    	.addAuditFilter({})	
	}
}); 
 		 
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addNumberColumn({ name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2 })  
		.addNumberColumn({ name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2 })  
		.addNumberColumn({ name:"totalAmount", dataIndex:"totalAmount",decimals:2 })  
		.addNumberColumn({ name:"customerId", dataIndex:"customerId", hidden:true,format:"0",width:70 })  
		.addTextColumn({ name:"customerCode", dataIndex:"customerCode",width:100 })   	
		.addNumberColumn({ name:"purchaseOrderId", dataIndex:"purchaseOrderId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$Edit", {
	extend: "dnet.core.dc.AbstractDcvForm",
	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoice$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addLov({ name:"customer", xtype:"net.nan21.dnet.module.bd.org.lovs.LegalEntityOrganizations", dataIndex:"customer",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:255,retFieldMapping: [{lovField:"id", dsField: "customerId"} ]  })
		.addLov({ name:"supplier", xtype:"net.nan21.dnet.module.bp.md.lovs.CustomersName", dataIndex:"supplier",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "supplierId"} ]  })
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" ,allowBlank:false})
		.addLov({ name:"currency", xtype:"net.nan21.dnet.module.bd.currency.lovs.Currencies", dataIndex:"currency",anchor:"-20" ,allowBlank:false, labelSeparator:"*",maxLength:32,retFieldMapping: [{lovField:"id", dsField: "currencyId"} ]  })
		.addDisplayFieldNumber({name:"totalNetAmount", dataIndex:"totalNetAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalTaxAmount", dataIndex:"totalTaxAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		.addDisplayFieldNumber({name:"totalAmount", dataIndex:"totalAmount",decimals:2, fieldCls:"displayfieldnumber important-field"  })
		//containers
		.addPanel({ name:"col1", layout:"form" ,width:250})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"col3", layout:"form" ,width:250})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ,"col3" ])
		.addChildrenTo("col1",["supplier","customer","code"])
		.addChildrenTo("col2",["currency","docDate"])
		.addChildrenTo("col3",["totalNetAmount","totalTaxAmount","totalAmount"])
;
	}	
});
