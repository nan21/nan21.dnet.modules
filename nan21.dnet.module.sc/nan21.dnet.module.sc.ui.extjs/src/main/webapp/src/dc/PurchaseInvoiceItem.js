   

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceItemDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceItem$EditList",
	
	_noImport_: true,
	_noExport_: true,
	_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"invoiceId", dataIndex:"invoiceId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"itemCode", xtype:"gridcolumn", dataIndex:"itemCode",width:100,editor:{xtype:"net.nan21.dnet.module.mm.md.lovs.Products" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "itemName"} ]} })
		.addTextColumn({ name:"itemName", dataIndex:"itemName",width:200 })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"uomCode", xtype:"gridcolumn", dataIndex:"uomCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"netAmount", dataIndex:"netAmount", align:"right",decimals:2})
	  	.addDefaults()
	  ;  		   
	}  
});