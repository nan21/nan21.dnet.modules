Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/InvTransactionTypeDs", "nan21.dnet.module.md.ui.extjs/dc/InvTransactionType","nan21.dnet.module.bd.ui.extjs/ds/TxDocTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/TxDocTypes","nan21.dnet.module.bd.ui.extjs/ds/TxDocTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/TxDocTypes"]);

Ext.define("net.nan21.dnet.module.md.tx.inventory.frame.InvTxTypes_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.tx.inventory.frame.InvTxTypes_UI",
	
	 _name_ : "net.nan21.dnet.module.md.tx.inventory.frame.InvTxTypes_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("txtype", new net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("txtype",{ name:"txtypeFilter", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType$Filter",height:120})	 
		.addDcEditGridView("txtype",{ name:"txtypeEditList", xtype:"net.nan21.dnet.module.md.tx.inventory.dc.InvTransactionType$EditList", frame:true})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["txtypeFilter","txtypeEditList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbTxtypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTxtypeEditList", {dc:"txtype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Inventory transaction types"}).end(); 	
	}

});  
