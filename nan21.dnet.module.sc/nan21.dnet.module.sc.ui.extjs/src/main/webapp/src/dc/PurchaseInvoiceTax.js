   

Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceTax", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceTaxDs",
	filterModel: "net.nan21.dnet.module.sc.invoice.ds.model.PurchaseInvoiceTaxDsFilter",
	paramModel: "net.nan21.dnet.module.sc.invoice.ds.param.PurchaseInvoiceTaxDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceTax$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.invoice.dc.PurchaseInvoiceTax$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"tax", dataIndex:"tax",width:120 })   	
		.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount",decimals:2 })  
		.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount",decimals:2 })  
		.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"purchaseInvoiceId", dataIndex:"purchaseInvoiceId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
