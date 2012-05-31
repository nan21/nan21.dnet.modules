Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/AccBalanceDs", "nan21.dnet.module.md.ui.extjs/dc/AccBalance","nan21.dnet.module.bd.ui.extjs/ds/LegalEntityOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/LegalEntityOrganizations","nan21.dnet.module.md.ui.extjs/ds/AccSchemaLovDs","nan21.dnet.module.md.ui.extjs/lov/AccSchemas","nan21.dnet.module.md.ui.extjs/ds/FiscalPeriodLovDs","nan21.dnet.module.md.ui.extjs/lov/FiscalPeriods"]);

Ext.define("net.nan21.dnet.module.md.tx.acc.frame.AccBalance_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.tx.acc.frame.AccBalance_UI",
	
	 _name_ : "net.nan21.dnet.module.md.tx.acc.frame.AccBalance_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("balance", new net.nan21.dnet.module.md.tx.acc.dc.AccBalance({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("balance",{ name:"balanceFilter", xtype:"net.nan21.dnet.module.md.tx.acc.dc.AccBalance$Filter"})	 
		.addDcGridView("balance",{ name:"balanceList", xtype:"net.nan21.dnet.module.md.tx.acc.dc.AccBalance$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["balanceFilter","balanceList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbBalanceList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbBalanceList", {dc:"balance"}).addQuery().addReports().end(); 	
	}

});  
