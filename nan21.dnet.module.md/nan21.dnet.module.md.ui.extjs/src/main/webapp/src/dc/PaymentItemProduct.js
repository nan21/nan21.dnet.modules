   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemProductDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemProductDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.PaymentItemProductDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"product", dataIndex:"product",anchor:"-20",maxLength:32  })
		.addTextField({ name:"uom", dataIndex:"uom",anchor:"-20",maxLength:32  })
		.addNumberField({ name:"quantity", dataIndex:"quantity",anchor:"-20"  })
		.addNumberField({ name:"unitPrice", dataIndex:"unitPrice",anchor:"-20"  })
		.addNumberField({ name:"amount", dataIndex:"amount",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["product","uom"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"product", dataIndex:"product",width:100 })   	
		.addTextColumn({ name:"uom", dataIndex:"uom",width:100 })   	
		.addNumberColumn({ name:"quantity", dataIndex:"quantity",decimals:2 })  
		.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice",decimals:2 })  
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$CtxEditListProduct", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.PaymentItemProduct$CtxEditListProduct",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"product", xtype:"gridcolumn", dataIndex:"product",width:100,editor:{xtype:"net.nan21.dnet.module.md.mm.prod.lovs.ProductsWithUom" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "productId"} ,{lovField:"uom", dsField: "uom"} ,{lovField:"uomId", dsField: "uomId"} ]} })
		.addLov({name:"uom", xtype:"gridcolumn", dataIndex:"uom",width:100,editor:{xtype:"net.nan21.dnet.module.bd.uom.lovs.UnitsOfMeasureCode" , selectOnFocus:true ,maxLength:32,retFieldMapping: [{lovField:"id", dsField: "uomId"} ]} })
		.addNumberColumn({ name:"quantity", dataIndex:"quantity", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"unitPrice", dataIndex:"unitPrice", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"amount", dataIndex:"amount", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"productId", dataIndex:"productId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"uomId", dataIndex:"uomId", hidden:true, align:"right",format:"0",width:70,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
	  	.addDefaults()
	  ;  		   
	}  
});
 	
