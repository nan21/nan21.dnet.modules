   

Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderTax", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderTaxDs",
	filterModel: "net.nan21.dnet.module.sd.order.ds.model.SalesOrderTaxDsFilter",
	paramModel: "net.nan21.dnet.module.sd.order.ds.param.SalesOrderTaxDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.sd.order.dc.SalesOrderTax$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.order.dc.SalesOrderTax$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"tax", dataIndex:"tax",width:120 })   	
		.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount",decimals:2 })  
		.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount",decimals:2 })  
		.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"salesOrderId", dataIndex:"salesOrderId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
