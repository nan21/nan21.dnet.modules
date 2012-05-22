   

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOutAmount", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutAmountDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PaymentOutAmountDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PaymentOutAmountDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	
 	 
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PaymentOutAmount$CtxEditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.sc.invoice.dc.PaymentOutAmount$CtxEditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addTextColumn({ name:"invoiceCode", dataIndex:"invoiceCode",width:100 })
		.addTextColumn({ name:"invoiceDocNo", dataIndex:"invoiceDocNo",width:200 })
		.addDateColumn({ name:"invoiceDocDate", dataIndex:"invoiceDocDate",format:Dnet.DATE_FORMAT})
		.addNumberColumn({ name:"expectedAmount", dataIndex:"expectedAmount", align:"right",decimals:2})
		.addNumberColumn({ name:"payedAmount", dataIndex:"payedAmount", align:"right",decimals:2})
		.addNumberColumn({ name:"dueAmount", dataIndex:"dueAmount", align:"right",decimals:2})
		.addNumberColumn({ name:"amount", dataIndex:"amount", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"txAmountId", dataIndex:"txAmountId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
