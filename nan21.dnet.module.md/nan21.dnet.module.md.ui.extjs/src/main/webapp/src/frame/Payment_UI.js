Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/PaymentDs", "nan21.dnet.module.md.ui.extjs/dc/Payment","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/FinancialAccountLovDs","nan21.dnet.module.md.ui.extjs/lov/FinancialAccounts","nan21.dnet.module.md.ui.extjs/ds/FinancialAccountLovDs","nan21.dnet.module.md.ui.extjs/lov/FinancialAccounts","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersName"]);

Ext.define("net.nan21.dnet.module.md.tx.fin.frame.Payment_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.frame.Payment_UI",
	
	 _name_ : "net.nan21.dnet.module.md.tx.fin.frame.Payment_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("payment", new net.nan21.dnet.module.md.tx.fin.dc.Payment({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("payment",{ name:"paymentFilter", xtype:"net.nan21.dnet.module.md.tx.fin.dc.Payment$Filter"})	 
		.addDcGridView("payment",{ name:"paymentList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.Payment$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["paymentFilter","paymentList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbPaymentList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbPaymentList", {dc:"payment"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Payments"}).end(); 	
	}

});  
