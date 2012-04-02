   

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceTax", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTaxDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesInvoiceTaxDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesInvoiceTaxDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceTax$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceTax$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"tax", dataIndex:"tax",width:120 })   	
		.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount",decimals:2 })  
		.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount",decimals:2 })  
		.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"salesInvoiceId", dataIndex:"salesInvoiceId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
