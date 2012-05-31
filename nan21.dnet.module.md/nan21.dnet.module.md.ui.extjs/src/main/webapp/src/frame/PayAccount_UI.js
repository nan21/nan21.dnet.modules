Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/PayAccountDs", "nan21.dnet.module.md.ui.extjs/dc/PayAccount", "nan21.dnet.module.md.ui.extjs/ds/PayAccountAcctDs", "nan21.dnet.module.md.ui.extjs/dc/PayAccountAcct", "nan21.dnet.module.md.ui.extjs/ds/PayAccountMethodDs", "nan21.dnet.module.md.ui.extjs/dc/PayAccountMethod","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.md.ui.extjs/ds/AccJournalLovDs","nan21.dnet.module.md.ui.extjs/lov/AccJournals","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.md.ui.extjs/ds/AccJournalLovDs","nan21.dnet.module.md.ui.extjs/lov/AccJournals","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.md.ui.extjs/lov/PaymentMethod"]);

Ext.define("net.nan21.dnet.module.md.org.frame.PayAccount_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.org.frame.PayAccount_UI",
	
	 _name_ : "net.nan21.dnet.module.md.org.frame.PayAccount_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("account", new net.nan21.dnet.module.md.org.dc.PayAccount({}))
		.addDc("acct", new net.nan21.dnet.module.md.org.dc.PayAccountAcct({multiEdit:true}))
		.addDc("paymethod", new net.nan21.dnet.module.md.org.dc.PayAccountMethod({multiEdit:true}))		
		.linkDc("acct", "account",{fields:[ {childField:"payAccountId", parentField:"id"} ]} )
		.linkDc("paymethod", "account",{fields:[ {childField:"payAccountId", parentField:"id"},{childField:"payAccountType", parentField:"type"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("account",{ name:"accountFilter", xtype:"net.nan21.dnet.module.md.org.dc.PayAccount$Filter",height:120})	 
		.addDcGridView("account",{ name:"accountList", xtype:"net.nan21.dnet.module.md.org.dc.PayAccount$List"})	 
		.addDcFormView("account",{ name:"accountEdit", xtype:"net.nan21.dnet.module.md.org.dc.PayAccount$Edit",height:140})	 
		.addDcEditGridView("acct",{ name:"acctEditList", xtype:"net.nan21.dnet.module.md.org.dc.PayAccountAcct$CtxEditList", frame:true,title:"Accounting"})	 
		.addDcEditGridView("paymethod",{ name:"paymethodEditList", xtype:"net.nan21.dnet.module.md.org.dc.PayAccountMethod$CtxEditList", frame:true,title:"Payment methods"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "detailsTab", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["accountFilter","accountList"] ,["north","center"])	
		.addChildrenTo("canvas2",["accountEdit","detailsTab"] ,["north","center"])	
	 	.addChildrenTo("detailsTab", ["paymethodEditList","acctEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbAccountList")	  	
	 	.addToolbarTo("canvas2","tlbAccountEdit")	  	
	 	.addToolbarTo("acctEditList","tlbAcctEditList")	  	
	 	.addToolbarTo("paymethodEditList","tlbPaymethodEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAccountList", {dc:"account"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Financial accounts"}).end()
			.beginToolbar("tlbAccountEdit", {dc:"account"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Financial account"}).end()
			.beginToolbar("tlbAcctEditList", {dc:"acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end()
			.beginToolbar("tlbPaymethodEditList", {dc:"paymethod"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Payment methods"}).end(); 	
	}

});  
