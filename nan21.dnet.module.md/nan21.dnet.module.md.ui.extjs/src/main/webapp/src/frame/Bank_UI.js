Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/BankDs", "nan21.dnet.module.md.ui.extjs/dc/Bank"]);

Ext.define("net.nan21.dnet.module.md.bp.frame.Bank_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.bp.frame.Bank_UI",
	
	 _name_ : "net.nan21.dnet.module.md.bp.frame.Bank_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("bank", new net.nan21.dnet.module.md.bp.dc.Bank({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("bank",{ name:"bankFilter", xtype:"net.nan21.dnet.module.md.bp.dc.Bank$Filter",height:80})	 
		.addDcEditGridView("bank",{ name:"bankEditList", xtype:"net.nan21.dnet.module.md.bp.dc.Bank$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["bankFilter","bankEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlb", {dc:"bank"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Banks"}).end(); 	
	}

});  
