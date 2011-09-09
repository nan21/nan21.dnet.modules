Dnet.doImport(["", "nan21.dnet.module.bp.ui.extjs/ds/BankDs", "nan21.dnet.module.bp.ui.extjs/dc/Bank"]);

Ext.ns("net.nan21.dnet.module.bp.base.frame");
net.nan21.dnet.module.bp.base.frame.Bank_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.base.frame.Bank_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("bank", new net.nan21.dnet.module.bp.base.dc.Bank({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("bank",{ name:"bankFilter", xtype:"net.nan21.dnet.module.bp.base.dc.Bank$Filter"})	 
		.addDcView("bank",{ name:"bankEditList", xtype:"net.nan21.dnet.module.bp.base.dc.Bank$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",header:false})  	 
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
			.beginToolbar("tlb", {dc:"bank"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Edit list"}).end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.bp.base.frame.Bank_UI", net.nan21.dnet.module.bp.base.frame.Bank_UI);   
