   

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemAccItemDs",
	filterModel: "net.nan21.dnet.module.md.tx.fin.ds.model.PaymentItemAccItemDsFilter",
	paramModel: "net.nan21.dnet.module.md.tx.fin.ds.param.PaymentItemAccItemDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"accItem", dataIndex:"accItem",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"amount", dataIndex:"amount",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1"])
		.addChildrenTo("col1",["accItem"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"accItem", dataIndex:"accItem",width:120 })   	
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"accItemId", dataIndex:"accItemId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	
 	 
Ext.define("net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$CtxEditListAccItem", {
	extend: "dnet.core.dc.AbstractDcvEditableGrid",
	alias: "widget.net.nan21.dnet.module.md.tx.fin.dc.PaymentItemAccItem$CtxEditListAccItem",
	
	_defineColumns_: function () {
		this._getBuilder_()
		.addLov({name:"accItem", xtype:"gridcolumn", dataIndex:"accItem",width:120,editor:{xtype:"net.nan21.dnet.module.md.acc.lovs.AccItems" , selectOnFocus:true ,maxLength:255,retFieldMapping: [{lovField:"id", dsField: "accItemId"} ]} })
		.addNumberColumn({ name:"amount", dataIndex:"amount", align:"right",decimals:2,editor:{xtype:"numberfield", selectOnFocus:true , decimalPrecision:2 } })
		.addNumberColumn({ name:"paymentId", dataIndex:"paymentId", hidden:true, align:"right",format:"0",width:70})
		.addNumberColumn({ name:"accItemId", dataIndex:"accItemId", hidden:true, align:"right",format:"0",width:70})
	  	.addDefaults()
	  ;  		   
	}  
});
 	
