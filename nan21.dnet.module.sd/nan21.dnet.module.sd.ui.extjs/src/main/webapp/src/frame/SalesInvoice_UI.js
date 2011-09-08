Dnet.import(["", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoice", "nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceItemDs", "nan21.dnet.module.sd.ui.extjs/dc/SalesInvoiceItem","nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesInvoiceStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesInvoiceType","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/LocationToBillLovDs","nan21.dnet.module.bd.ui.extjs/lov/LocationsToBill","nan21.dnet.module.bp.ui.extjs/ds/BpContactLovDs","nan21.dnet.module.bp.ui.extjs/lov/BpContacts","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/Customers","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/Customers","nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceStatusLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesInvoiceStatus","nan21.dnet.module.sd.ui.extjs/ds/SalesInvoiceTypeLovDs","nan21.dnet.module.sd.ui.extjs/lov/SalesInvoiceType","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure"]);

Ext.ns("net.nan21.dnet.module.sd.invoice.frame");
net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("inv", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoice())
		.addDc("item", new net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem({multiEdit:true}))		
		.linkDc("item", "inv",{fields:[ {childField:"invoiceId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("inv",{ name:"invFilter", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Filter"})	 
		.addDcView("inv",{ name:"invList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$List"})	 
		.addDcFormView("inv",{ name:"invEdit", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoice$Edit",height:150})	 
		.addDcView("item",{ name:"itemEditList", xtype:"net.nan21.dnet.module.sd.invoice.dc.SalesInvoiceItem$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["invFilter","invList"] ,["north","center"])	
		.addChildrenTo("canvas2",["invEdit","itemEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbInvList")	  	
	 	.addToolbarTo("canvas2","tlbInvEdit")	  	
	 	.addToolbarTo("itemEditList","tlbItemEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvList", {dc:"inv"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbInvEdit", {dc:"inv"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbItemEditList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

	,refreshHeader: function() {	
		
		this._getDc_("item").on("afterDoSaveSuccess", 
		function() {
			this._getDc_("inv").doRefreshCurrent();
		} , this );
	}
	,_afterDefineDcs_: function() {	
		this.refreshHeader();
	}
});
Ext.reg("net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI", net.nan21.dnet.module.sd.invoice.frame.SalesInvoice_UI);   
