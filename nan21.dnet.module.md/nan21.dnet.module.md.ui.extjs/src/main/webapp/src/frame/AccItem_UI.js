Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/AccItemDs", "nan21.dnet.module.md.ui.extjs/dc/AccItem", "nan21.dnet.module.md.ui.extjs/ds/AccItemAcctDs", "nan21.dnet.module.md.ui.extjs/dc/AccItemAcct","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts","nan21.dnet.module.md.ui.extjs/ds/AccountLovDs","nan21.dnet.module.md.ui.extjs/lov/Accounts"]);

Ext.define("net.nan21.dnet.module.md.acc.frame.AccItem_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.acc.frame.AccItem_UI",
	
	 _name_ : "net.nan21.dnet.module.md.acc.frame.AccItem_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("item", new net.nan21.dnet.module.md.acc.dc.AccItem({multiEdit:true}))
		.addDc("acct", new net.nan21.dnet.module.md.acc.dc.AccItemAcct({multiEdit:true}))		
		.linkDc("acct", "item",{fields:[ {childField:"accItemId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("item",{ name:"itemFilter", xtype:"net.nan21.dnet.module.md.acc.dc.AccItem$Filter"})	 
		.addDcEditGridView("item",{ name:"itemEditList", xtype:"net.nan21.dnet.module.md.acc.dc.AccItem$EditList", frame:true})	 
		.addDcEditGridView("acct",{ name:"acctEditList", xtype:"net.nan21.dnet.module.md.acc.dc.AccItemAcct$CtxEditList", frame:true,height:200})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["itemFilter","itemEditList","acctEditList"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbItemList")	  	
	 	.addToolbarTo("acctEditList","tlbAcctList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbItemList", {dc:"item"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().end()
			.beginToolbar("tlbAcctList", {dc:"acct"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Accounting"}).end(); 	
	}

});  
