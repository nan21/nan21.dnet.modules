   

Ext.define("net.nan21.dnet.module.sd.invoice.dc.PaymentIn", {
	extend: "dnet.core.dc.AbstractDc",
 
	recordModel: "net.nan21.dnet.module.sd.invoice.ds.model.PaymentInDs",
	filterModel: "net.nan21.dnet.module.sd.invoice.ds.model.PaymentInDsFilter",
	paramModel: "net.nan21.dnet.module.sd.invoice.ds.param.PaymentInDsParam",
	constructor : function(config) {
        config = config || {};
        Ext.apply(this, config);
        this.callParent();
	}	
});



 	

Ext.define("net.nan21.dnet.module.sd.invoice.dc.PaymentIn$Filter", {
	extend: "dnet.core.dc.AbstractDcvFilterForm",
 	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.PaymentIn$Filter",
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code",_sharedLabel_:true, dataIndex:"code",anchor:"-20",maxLength:32  })
		.addDateField({ name:"docDate_From", dataIndex:"docDate_From", emptyText:"From" })
		.addDateField({ name:"docDate_To", dataIndex:"docDate_To", emptyText:"To" })
		.addFieldContainer({name: "docDate", fieldLabel:"Doc Date"}) 
		.addChildrenTo("docDate",["docDate_From", "docDate_To"]) 

		.addTextField({ name:"payTo", dataIndex:"payTo",anchor:"-20",maxLength:32  })
		.addTextField({ name:"payToName", dataIndex:"payToName",anchor:"-20",maxLength:255  })
		.addTextField({ name:"org", dataIndex:"org",anchor:"-20",maxLength:32  })
		.addTextField({ name:"currency", dataIndex:"currency",anchor:"-20",maxLength:32  })
		.addTextField({ name:"paymentMethod", dataIndex:"paymentMethod",anchor:"-20",maxLength:255  })
		.addNumberField({ name:"amount_From", dataIndex:"amount_From", emptyText:"From" })
		.addNumberField({ name:"amount_To", dataIndex:"amount_To", emptyText:"To" })
		.addFieldContainer({name: "amount", fieldLabel:"Amount"})  
		.addChildrenTo("amount",["amount_From", "amount_To"]) 

		.addBooleanField({ name:"confirmed", dataIndex:"confirmed",anchor:"-20"  })
		.addBooleanField({ name:"posted", dataIndex:"posted",anchor:"-20"  })
		//containers
		.addPanel({ name:"col1", layout:"form",width:210}) 
		.addPanel({ name:"col2", layout:"form",width:210}) 
		.addPanel({ name:"col3", layout:"form",width:210}) 
		.addPanel({ name:"main", layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}} , autoScroll:true, padding:"0 30 0 0" })     
		
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1","col2"])
		.addChildrenTo("col1",["code","payTo","org","currency","paymentMethod"])
		.addChildrenTo("col2",["docDate","amount"])
		.addChildrenTo("col3",["confirmed","posted"])
    	.addAuditFilter()	
	}
}); 
 	
 		 
Ext.define("net.nan21.dnet.module.sd.invoice.dc.PaymentIn$List", {
	extend: "dnet.core.dc.AbstractDcvGrid",
	alias:"widget.net.nan21.dnet.module.sd.invoice.dc.PaymentIn$List",
	
	_defineColumns_: function () {	
		this._getBuilder_()	
		.addTextColumn({ name:"code", dataIndex:"code",width:100 })   	
		.addDateColumn({ name:"docDate", dataIndex:"docDate",format:Dnet.DATE_FORMAT})   	      	     
		.addTextColumn({ name:"payTo", dataIndex:"payTo",width:100 })   	
		.addTextColumn({ name:"payToName", dataIndex:"payToName",width:200 })   	
		.addTextColumn({ name:"org", dataIndex:"org",width:100 })   	
		.addTextColumn({ name:"currency", dataIndex:"currency",width:100 })   	
		.addTextColumn({ name:"paymentMethod", dataIndex:"paymentMethod",width:120 })   	
		.addNumberColumn({ name:"amount", dataIndex:"amount",decimals:2 })  
		.addBooleanColumn({ name:"confirmed", dataIndex:"confirmed"})   	     
		.addBooleanColumn({ name:"posted", dataIndex:"posted"})   	     
		.addNumberColumn({ name:"payToId", dataIndex:"payToId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"orgId", dataIndex:"orgId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"paymentMethodId", dataIndex:"paymentMethodId", hidden:true,format:"0",width:70 })  
		.addNumberColumn({ name:"currencyId", dataIndex:"currencyId", hidden:true,format:"0",width:70 })  
	  	.addDefaults()
	  ;		   
	}
});
 
 	
 	

Ext.define("net.nan21.dnet.module.sd.invoice.dc.PaymentIn$Edit", {
	extend: "dnet.core.dc.AbstractDcvEditForm",
	alias: "widget.net.nan21.dnet.module.sd.invoice.dc.PaymentIn$Edit",
	
	_defineElements_: function () {	
		//controls	
		this._getBuilder_()	
		.addTextField({ name:"code", dataIndex:"code",anchor:"-20" ,maxLength:32  })
		.addDateField({ name:"docDate", dataIndex:"docDate",anchor:"-20" })
		.addTextField({ name:"payTo", dataIndex:"payTo",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"payToName", dataIndex:"payToName",anchor:"-20" ,maxLength:255  })
		.addTextField({ name:"org", dataIndex:"org",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"currency", dataIndex:"currency",anchor:"-20" ,maxLength:32  })
		.addTextField({ name:"paymentMethod", dataIndex:"paymentMethod",anchor:"-20" ,maxLength:255  })
		.addNumberField({ name:"amount", dataIndex:"amount",anchor:"-20"  , style: "text-align:right;" })
		.addCheckbox({ name:"confirmed", dataIndex:"confirmed"  })
		.addCheckbox({ name:"posted", dataIndex:"posted"  })
		//containers
		.addPanel({ name:"col1", layout:"form" , width:300})     
		.addPanel({ name:"col2", layout:"form" , width:300})     
		.addPanel({ name:"main",  layout: { type:"hbox", align:'top' , pack:'start', defaultMargins: {right:5, left:5}}, autoScroll:true, padding:"0 30 5 0" }) 
		;     
	}
	,_linkElements_: function () {
		this._getBuilder_()
		.addChildrenTo("main",["col1" ,"col2" ])
		.addChildrenTo("col1",["org","payTo","payToName","code","docDate"])
		.addChildrenTo("col2",["currency","paymentMethod","amount","confirmed","posted"])
;
	}	
});
 	
