   

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem", {
	extend: "dnet.base.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceItemDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$EditList", {
	extend: "dnet.base.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$EditList",
	
	 _noImport_: true
	,_noExport_: true
	,_defineColumns_: function () {
		this._getBuilder_()
		.addNumberColumn({ name:"invoiceId", dataIndex:"invoiceId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"itemId", dataIndex:"itemId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"itemCode", xtype:"gridcolumn", dataIndex:"itemCode",width:100,editor:{xtype:"net.nan21.dnet.module.mm.md.lovs.Products" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "itemId"} ,{lovField:"name", dsField: "itemName"} ]} })
		.addTextColumn({ name:"itemName", dataIndex:"itemName",width:200 })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, align:"right",format:"0",width:70})
		.addLov({name:"uomCode", xtype:"gridcolumn", dataIndex:"uomCode",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasure" , selectOnFocus:true,maxLength:32,autoCreate: {tag: "input", type: "text", autocomplete: "off", size: "20", maxlength: "32"},retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true ,decimalPrecision:2 } })
		.addNumberColumn({ name:"netAmount", dataIndex:"netAmount", align:"right",decimals:2})
		.addNumberColumn({ name:"id", dataIndex:"id", hidden:true, align:"right",format:"0",width:70})
		.addDateColumn({ name:"createdAt", dataIndex:"createdAt", hidden:true,format:Dnet.DATETIME_FORMAT})
		.addDateColumn({ name:"modifiedAt", dataIndex:"modifiedAt",format:Dnet.DATETIME_FORMAT})
		.addTextColumn({ name:"createdBy", dataIndex:"createdBy", hidden:true,width:100 })
		.addTextColumn({ name:"modifiedBy", dataIndex:"modifiedBy",width:100 })
	  ;  		   
	}  
});
