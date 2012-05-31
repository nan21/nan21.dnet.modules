Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/UiViewStateDs", "nan21.dnet.module.ad.ui.extjs/dc/UiViewState"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.UiViewState_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.system.frame.UiViewState_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.system.frame.UiViewState_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("viewstate", new net.nan21.dnet.module.ad.system.dc.UiViewState({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("viewstate",{ name:"viewstateFilter", xtype:"net.nan21.dnet.module.ad.system.dc.UiViewState$Filter"})	 
		.addDcGridView("viewstate",{ name:"viewstateList", xtype:"net.nan21.dnet.module.ad.system.dc.UiViewState$List"})	 
		.addDcFormView("viewstate",{ name:"viewstateViewState", xtype:"net.nan21.dnet.module.ad.system.dc.UiViewState$ViewState",height:100})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["viewstateFilter","viewstateList","viewstateViewState"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbViewstateList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbViewstateList", {dc:"viewstate"}).addQuery().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"View states"}).end(); 	
	}

});  
