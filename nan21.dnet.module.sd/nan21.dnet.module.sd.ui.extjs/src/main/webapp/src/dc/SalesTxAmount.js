   

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.SalesTxAmountDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.SalesTxAmountDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addDateField({ name:"dueDate", dataIndex:"dueDate",anchor:"-20" ,format:Ext.DATE_FORMAT })
		.addNumberField({ name:"amount", dataIndex:"amount",anchor:"-20"  })
		.addNumberField({ name:"payedAmount", dataIndex:"payedAmount",anchor:"-20"  })
		.addNumberField({ name:"dueAmount", dataIndex:"dueAmount",anchor:"-20"  })
		.addTextField({ name:"paymentMethod", dataIndex:"paymentMethod",anchor:"-20",maxLength:255  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["paymentMethod"])
    	.addAuditFilter()	
	}
}); 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount$EditList", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.SalesTxAmount$EditList",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addDateColumn({ name:"dueDate", dataIndex:"dueDate",format:Dnet.DATE_FORMAT,editor:{xtype:"datefield", selectOnFocus:true , format:Dnet.DATE_FORMAT}})
		.addLov({name:"paymentMethod", xtype:"gridcolumn", dataIndex:"paymentMethod",width:120,editor:{xtype:"net.nan21.dnet.module.md.base.tx.lovs.PaymentMethodIn" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "paymentMethodId"} ]} })
		.addNumberColumn({ name:"amount", dataIndex:"amount", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"payedAmount", dataIndex:"payedAmount", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"dueAmount", dataIndex:"dueAmount", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"invoiceId", dataIndex:"invoiceId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"orderId", dataIndex:"orderId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
