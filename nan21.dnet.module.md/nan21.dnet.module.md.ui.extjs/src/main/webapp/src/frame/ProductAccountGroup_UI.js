Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/ProductAccountGroupDs", "nan21.dnet.module.md.ui.extjs/dc/ProductAccountGroup", "nan21.dnet.module.md.ui.extjs/ds/ProductAccountGroupAcctDs", "nan21.dnet.module.md.ui.extjs/dc/ProductAccountGroupAcct","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts"]);

Ext.define("net.nan21.dnet.module.md.mm.prod.frame.ProductAccountGroup_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.mm.prod.frame.ProductAccountGroup_UI",
	
	 _name_ : "net.nan21.dnet.module.md.mm.prod.frame.ProductAccountGroup_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("account", new net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroup({multiEdit:true}))
		.addDc("acct", new net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroupAcct({multiEdit:true}))		
		.linkDc("acct", "account",{fields:[ {childField:"groupId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("account",{ name:"accountFilter", xtype:"net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroup$Filter",height:80})	 
		.addDcEditGridView("account",{ name:"accountEditList", xtype:"net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroup$EditList", frame:true})	 
		.addDcEditGridView("acct",{ name:"acctEditList", xtype:"net.nan21.dnet.module.md.mm.prod.dc.ProductAccountGroupAcct$CtxEditList", frame:true,height:200})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["accountFilter","accountEditList","acctEditList"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbAccount")	  	
	 	.addToolbarTo("acctEditList","tlbAcct")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAccount", {dc:"account"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Product account groups"}).end()
			.beginToolbar("tlbAcct", {dc:"acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end(); 	
	}

});  
