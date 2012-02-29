Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/InvOperationDs", "nan21.dnet.module.mm.ui.extjs/dc/InvOperation","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.bd.ui.extjs/ds/InventoryOrganizationLovDs","nan21.dnet.module.bd.ui.extjs/lov/InventoryOrganizations","nan21.dnet.module.mm.ui.extjs/ds/SubInventoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/SubInventorys","nan21.dnet.module.mm.ui.extjs/ds/StockLocatorLovDs","nan21.dnet.module.mm.ui.extjs/lov/StockLocators"]);

Ext.define("net.nan21.dnet.module.mm.inventory.frame.InvOperations_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.inventory.frame.InvOperations_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.inventory.frame.InvOperations_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("invop", new net.nan21.dnet.module.mm.inventory.dc.InvOperation({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("invop",{ name:"invopFilter", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvOperation$Filter",height:120})	 
		.addDcGridView("invop",{ name:"invopList", xtype:"net.nan21.dnet.module.mm.inventory.dc.InvOperation$List"})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["invopFilter","invopList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbInvopList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbInvopList", {dc:"invop"}).addQuery().addReports().addSeparator().addSeparator().addTitle({"text":"Inventory operations"}).end(); 	
	}

});  
