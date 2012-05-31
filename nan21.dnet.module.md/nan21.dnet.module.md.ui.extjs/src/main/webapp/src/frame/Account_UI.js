Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/AccountDs", "nan21.dnet.module.md.ui.extjs/dc/Account","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas"]);

Ext.define("net.nan21.dnet.module.md.acc.frame.Account_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.acc.frame.Account_UI",
	
	 _name_ : "net.nan21.dnet.module.md.acc.frame.Account_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("account", new net.nan21.dnet.module.md.acc.dc.Account({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("account",{ name:"accountFilter", xtype:"net.nan21.dnet.module.md.acc.dc.Account$Filter",height:90})	 
		.addDcGridView("account",{ name:"accountList", xtype:"net.nan21.dnet.module.md.acc.dc.Account$List"})	 
		.addDcEditGridView("account",{ name:"accountEditList", xtype:"net.nan21.dnet.module.md.acc.dc.Account$EditList", frame:true})	 
		.addDcFormView("account",{ name:"accountEdit", xtype:"net.nan21.dnet.module.md.acc.dc.Account$Edit"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["accountFilter","accountEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbSchemaList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSchemaList", {dc:"account"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().end(); 	
	}

});  
