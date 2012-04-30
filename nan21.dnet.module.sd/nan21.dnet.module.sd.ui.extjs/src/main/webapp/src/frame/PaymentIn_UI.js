Dnet.doImport(["", "nan21.dnet.module.sd.ui.extjs/ds/PaymentInDs", "nan21.dnet.module.sd.ui.extjs/dc/PaymentIn"]);

Ext.define("net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI",
	
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.PaymentIn_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("payment", new net.nan21.dnet.module.sd.invoice.dc.PaymentIn({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("payment",{ name:"paymentFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.PaymentIn$Filter"})	 
		.addDcGridView("payment",{ name:"paymentList", xtype:"net.nan21.dnet.module.sd.invoice.dc.PaymentIn$List"})	 
		.addDcFormView("payment",{ name:"paymentEdit", xtype:"net.nan21.dnet.module.sd.invoice.dc.PaymentIn$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["paymentFilter","paymentList"] ,["north","center"])	
		.addChildrenTo("canvas2",["paymentEdit"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbPaymentList")	  	
	 	.addToolbarTo("canvas2","tlbPaymentEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPaymentList", {dc:"payment"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Payments In"}).end()
			.beginToolbar("tlbPaymentEdit", {dc:"payment"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Payment In"}).end(); 	
	}

});  
