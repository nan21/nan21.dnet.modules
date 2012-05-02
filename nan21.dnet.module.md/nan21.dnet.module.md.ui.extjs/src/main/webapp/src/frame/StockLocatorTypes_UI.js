Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/StockLocatorTypeDs", "nan21.dnet.module.md.ui.extjs/dc/StockLocatorType"]);

Ext.define("net.nan21.dnet.module.md.org.frame.StockLocatorTypes_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.org.frame.StockLocatorTypes_UI",
	
	 _name_ : "net.nan21.dnet.module.md.org.frame.StockLocatorTypes_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("sloctype", new net.nan21.dnet.module.md.org.dc.StockLocatorType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("sloctype",{ name:"sloctypeFilter", xtype:"net.nan21.dnet.module.md.org.dc.StockLocatorType$Filter",height:120})	 
		.addDcEditGridView("sloctype",{ name:"sloctypeEditList", xtype:"net.nan21.dnet.module.md.org.dc.StockLocatorType$EditList", frame:true})	 
		.addPanel({name: "main", layout:"border", defaults:{split:true}})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
		.addChildrenTo("main",["sloctypeFilter","sloctypeEditList"] ,["north","center"])	
	 	.addToolbarTo("main","tlbSloctypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbSloctypeEditList", {dc:"sloctype"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Locator types"}).end(); 	
	}

});  
