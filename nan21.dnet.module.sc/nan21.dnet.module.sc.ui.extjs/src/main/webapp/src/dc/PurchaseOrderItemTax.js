   

Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItemTax", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemTaxDs",
	filterModel: "net.nan21.dnet.module.sc.order.ds.model.PurchaseOrderItemTaxDsFilter",
	paramModel: "net.nan21.dnet.module.sc.order.ds.param.PurchaseOrderItemTaxDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 		 
Ext.define("net.nan21.dnet.module.sc.order.dc.PurchaseOrderItemTax$CtxList", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sc.order.dc.PurchaseOrderItemTax$CtxList",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"tax", dataIndex:"tax",width:120 })   	
		.addNumberColumn({ name:"baseAmount", dataIndex:"baseAmount",decimals:2 })  
		.addNumberColumn({ name:"taxAmount", dataIndex:"taxAmount",decimals:2 })  
		.addNumberColumn({ name:"taxId", dataIndex:"taxId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"purchaseOrderItemId", dataIndex:"purchaseOrderItemId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
