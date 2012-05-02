Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/AccOperationDs", "nan21.dnet.module.md.ui.extjs/dc/AccOperation"]);

Ext.define("net.nan21.dnet.module.md.tx.fin.frame.AccOperation_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.tx.fin.frame.AccOperation_UI",
	
	 _name_ : "net.nan21.dnet.module.md.tx.fin.frame.AccOperation_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("op", new net.nan21.dnet.module.md.tx.fin.dc.AccOperation({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("op",{ name:"opFilter", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccOperation$Filter"})	 
		.addDcGridView("op",{ name:"opList", xtype:"net.nan21.dnet.module.md.tx.fin.dc.AccOperation$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["opFilter","opList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbOpList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbOpList", {dc:"op"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().end(); 	
	}

});  
