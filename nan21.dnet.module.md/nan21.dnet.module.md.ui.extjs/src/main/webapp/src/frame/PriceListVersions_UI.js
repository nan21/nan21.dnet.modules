Dnet.doImport(["", "nan21.dnet.module.md.ui.extjs/ds/PriceListVersionDs", "nan21.dnet.module.md.ui.extjs/dc/PriceListVersion","nan21.dnet.module.md.ui.extjs/ds/PriceListLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceList","nan21.dnet.module.md.ui.extjs/ds/PriceListLovDs","nan21.dnet.module.md.ui.extjs/lov/PriceList"]);

Ext.define("net.nan21.dnet.module.md.mm.price.frame.PriceListVersions_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.md.mm.price.frame.PriceListVersions_UI",
	
	 _name_ : "net.nan21.dnet.module.md.mm.price.frame.PriceListVersions_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("version", new net.nan21.dnet.module.md.mm.price.dc.PriceListVersion({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("version",{ name:"versionFilter", xtype:"net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$Filter",height:80})	 
		.addDcEditGridView("version",{ name:"versionEditList", xtype:"net.nan21.dnet.module.md.mm.price.dc.PriceListVersion$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["versionFilter","versionEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbVersionEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbVersionEditList", {dc:"version"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Price list versions"}).end(); 	
	}

});  
