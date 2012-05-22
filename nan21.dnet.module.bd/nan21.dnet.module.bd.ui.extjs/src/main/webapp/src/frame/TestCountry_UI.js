Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/CountryDs", "nan21.dnet.module.bd.ui.extjs/dc/Country"]);

Ext.define("net.nan21.dnet.module.bd.geo.frame.TestCountry_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.geo.frame.TestCountry_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.geo.frame.TestCountry_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("country", new net.nan21.dnet.module.bd.geo.dc.Country({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("country",{ name:"countryFilter", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$Filter",height:120})	 
		.addDcFilterFormView("country",{ name:"countryFilterPG", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$FilterPG",width:300})	 
		.addDcGridView("country",{ name:"countryList", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$List",title:"Grid"})	 
		.addDcEditGridView("country",{ name:"countryEditList", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$EditList", frame:true,title:"Edit-Grid"})	 
		.addDcFormView("country",{ name:"countryEdit", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$Edit",height:120})	 
		.addDcFormView("country",{ name:"countryEditPG", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$EditPG",width:300})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "gridTabs", xtype:"tabpanel", activeTab:0, plain:false, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["countryFilter","gridTabs","countryEdit","countryEditPG","countryFilterPG"] ,["north","center","south","east","west"])	
	 	.addChildrenTo("gridTabs", ["countryList","countryEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbList")	  	
	 	.addToolbarTo("countryEdit","tlbEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbList", {dc:"country"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Countries"}).end()
			.beginToolbar("tlbEdit", {dc:"country"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Country"}).end(); 	
	}

});  
