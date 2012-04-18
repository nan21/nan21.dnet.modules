Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/InvBalanceDs", "nan21.dnet.module.mm.ui.extjs/dc/InvBalance","nan21.dnet.module.mm.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/SubInventorys","nan21.dnet.module.mm.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.mm.ui.extjs/lov/StockLocators","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure"]);

Ext.define("net.nan21.dnet.module.mm.inventory.frame.InvBalance_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.inventory.frame.InvBalance_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.inventory.frame.InvBalance_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("invbalance", new net.nan21.dnet.module.mm.inventory.dc.InvBalance({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("invbalance",{ name:"invbalanceFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvBalance$Filter",height:100})	 
		.addDcGridView("invbalance",{ name:"invbalanceList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvBalance$List"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["invbalanceFilter","invbalanceList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbInvbalanceList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvbalanceList", {dc:"invbalance"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Stocks"}).end(); 	
	}

});  
