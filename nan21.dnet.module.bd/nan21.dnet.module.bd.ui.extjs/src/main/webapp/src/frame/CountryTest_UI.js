Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/CountryDs", "nan21.dnet.module.bd.ui.extjs/dc/Country", "nan21.dnet.module.bd.ui.extjs/ds/RegionDs", "nan21.dnet.module.bd.ui.extjs/dc/Region"]);

Ext.define("net.nan21.dnet.module.bd.geo.frame.CountryTest_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.geo.frame.CountryTest_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.geo.frame.CountryTest_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("country", new net.nan21.dnet.module.bd.geo.dc.Country({}))
		.addDc("region", new net.nan21.dnet.module.bd.geo.dc.Region({multiEdit:true}))		
		.linkDc("region", "country",{fields:[ {childField:"countryId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("country",{ name:"countryFilter", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$Filter"})	 
		.addDcView("country",{ name:"countryList", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$List"})	 
		.addDcFormView("country",{ name:"countryEdit", xtype:"net.nan21.dnet.module.bd.geo.dc.Country$Edit",width:700})	 
		.addDcView("region",{ name:"regionEditList", xtype:"net.nan21.dnet.module.bd.geo.dc.Region$EditListContext", frame:true,height:100})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["countryFilter","countryList","countryEdit","regionEditList"] ,["north","center","east","south"])	
	 	.addToolbarTo("canvas1","tlbCountryList")	  	
	 	.addToolbarTo("countryEdit","tlbCountryEdit")	  	
	 	.addToolbarTo("regionEditList","tlbRegionList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCountryList", {dc:"country"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbCountryEdit", {dc:"country"}).addSave().addNew().addCopy().addCancel().end()
			.beginToolbar("tlbRegionList", {dc:"region"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}

});  
