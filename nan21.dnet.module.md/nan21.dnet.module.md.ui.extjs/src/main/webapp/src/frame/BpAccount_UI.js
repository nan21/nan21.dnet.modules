Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/BpAccountDs", "nan21.dnet.module.md.ui.extjs/dc/BpAccount", "nan21.dnet.module.md.ui.extjs/ds/BpAccountAcctDs", "nan21.dnet.module.md.ui.extjs/dc/BpAccountAcct","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersCode","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/CustomerGroupLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomerGroup","nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bd.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentTerm","nan21.dnet.module.md.ui.extjs/ds/VendorGroupLovDs","nan21.dnet.module.md.ui.extjs/lov/VendorGroup","nan21.dnet.module.bd.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bd.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bd.ui.extjs/lov/PaymentTerm","nan21.dnet.module.md.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.md.ui.extjs/lov/BusinessPartnersCode","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/CustomerGroupLovDs","nan21.dnet.module.md.ui.extjs/lov/CustomerGroup","nan21.dnet.module.md.ui.extjs/ds/VendorGroupLovDs","nan21.dnet.module.md.ui.extjs/lov/VendorGroup","nan21.dnet.module.bd.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.bd.ui.extjs/lov/AccSchemas","nan21.dnet.module.bd.ui.extjs/ds/AccountLovDs","nan21.dnet.module.bd.ui.extjs/lov/Accounts","nan21.dnet.module.bd.ui.extjs/ds/AccountLovDs","nan21.dnet.module.bd.ui.extjs/lov/Accounts","nan21.dnet.module.bd.ui.extjs/ds/AccountLovDs","nan21.dnet.module.bd.ui.extjs/lov/Accounts","nan21.dnet.module.bd.ui.extjs/ds/AccountLovDs","nan21.dnet.module.bd.ui.extjs/lov/Accounts"]);

Ext.define("net.nan21.dnet.module.md.bp.frame.BpAccount_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.bp.frame.BpAccount_UI",
	
	 _name_ : "net.nan21.dnet.module.md.bp.frame.BpAccount_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("account", new net.nan21.dnet.module.md.bp.dc.BpAccount({}))
		.addDc("acct", new net.nan21.dnet.module.md.bp.dc.BpAccountAcct({multiEdit:true}))		
		.linkDc("acct", "account",{fields:[ {childField:"bpAccountId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("account",{ name:"accountFilter", xtype:"net.nan21.dnet.module.md.bp.dc.BpAccount$Filter",height:120})	 
		.addDcGridView("account",{ name:"accountList", xtype:"net.nan21.dnet.module.md.bp.dc.BpAccount$List"})	 
		.addDcFormView("account",{ name:"accountEdit", xtype:"net.nan21.dnet.module.md.bp.dc.BpAccount$Edit",height:150})	 
		.addDcEditGridView("acct",{ name:"acctEditList", xtype:"net.nan21.dnet.module.md.bp.dc.BpAccountAcct$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["accountFilter","accountList"] ,["north","center"])	
		.addChildrenTo("canvas2",["accountEdit","acctEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbAccountList")	  	
	 	.addToolbarTo("canvas2","tlbAccountEdit")	  	
	 	.addToolbarTo("acctEditList","tlbAcctList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAccountList", {dc:"account"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"BP accounts"}).end()
			.beginToolbar("tlbAccountEdit", {dc:"account"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"BP account"}).end()
			.beginToolbar("tlbAcctList", {dc:"acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end(); 	
	}

});  
