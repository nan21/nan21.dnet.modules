Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/RegionDs", "nan21.dnet.module.bd.ui.extjs/dc/Region", "nan21.dnet.module.bd.ui.extjs/ds/CityDs", "nan21.dnet.module.bd.ui.extjs/dc/City","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries"]);

Ext.define("net.nan21.dnet.module.bd.geo.frame.RegionMD_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.geo.frame.RegionMD_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.geo.frame.RegionMD_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("region", new net.nan21.dnet.module.bd.geo.dc.Region({}))
		.addDc("city", new net.nan21.dnet.module.bd.geo.dc.City({multiEdit:true}))		
		.linkDc("city", "region",{fields:[ {childField:"regionId", parentField:"id"},{childField:"countryId", parentField:"countryId"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("region",{ name:"regionFilter", xtype:"net.nan21.dnet.module.bd.geo.dc.Region$Filter",height:80})	 
		.addDcGridView("region",{ name:"regionList", xtype:"net.nan21.dnet.module.bd.geo.dc.Region$List"})	 
		.addDcFormView("region",{ name:"regionEdit", xtype:"net.nan21.dnet.module.bd.geo.dc.Region$Edit",height:120})	 
		.addDcEditGridView("city",{ name:"cityEditList", xtype:"net.nan21.dnet.module.bd.geo.dc.City$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["regionFilter","regionList"] ,["north","center"])	
		.addChildrenTo("canvas2",["regionEdit","cityEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbRegionList")	  	
	 	.addToolbarTo("canvas2","tlbRegionEdit")	  	
	 	.addToolbarTo("cityEditList","tlbCityList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbRegionList", {dc:"region"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Regions"}).end()
			.beginToolbar("tlbRegionEdit", {dc:"region"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Region"}).end()
			.beginToolbar("tlbCityList", {dc:"city"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().addReports().addSeparator().addSeparator().addTitle({"text":"Cities"}).end(); 	
	}

});  
