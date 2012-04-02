Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductDs", "nan21.dnet.module.mm.ui.extjs/dc/TestProduct","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeGroup","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomMassLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomMass","nan21.dnet.module.bd.ui.extjs/ds/UomVolumeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomVolume","nan21.dnet.module.bd.ui.extjs/ds/UomLengthLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomLength","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeGroup","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomMassLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomMass","nan21.dnet.module.bd.ui.extjs/ds/UomVolumeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomVolume","nan21.dnet.module.bd.ui.extjs/ds/UomLengthLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomLength","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeGroup","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductAttributeGroupLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductAttributeGroup","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories"]);

Ext.define("net.nan21.dnet.module.mm.md.frame.TestCountry_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.md.frame.TestCountry_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.md.frame.TestCountry_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prod", new net.nan21.dnet.module.mm.md.dc.TestProduct({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("prod",{ name:"prodFilter", xtype:"net.nan21.dnet.module.mm.md.dc.TestProduct$Filter",height:120})	 
		.addDcFilterFormView("prod",{ name:"prodFilterPG", xtype:"net.nan21.dnet.module.mm.md.dc.TestProduct$FilterPG",width:300})	 
		.addDcGridView("prod",{ name:"prodList", xtype:"net.nan21.dnet.module.mm.md.dc.TestProduct$List",title:"Grid"})	 
		.addDcGridView("prod",{ name:"prodEditList", xtype:"net.nan21.dnet.module.mm.md.dc.TestProduct$EditList",title:"Edit-Grid"})	 
		.addDcFormView("prod",{ name:"prodEdit", xtype:"net.nan21.dnet.module.mm.md.dc.TestProduct$Edit",height:120})	 
		.addDcFormView("prod",{ name:"prodEditPG", xtype:"net.nan21.dnet.module.mm.md.dc.TestProduct$EditPG",width:300})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 

		.addPanel({name: "gridTabs", xtype:"tabpanel", activeTab:0, plain:true, deferredRender:false, id:Ext.id()}) 	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["prodFilter","gridTabs","prodEdit","prodEditPG","prodFilterPG"] ,["north","center","south","east","west"])	
	 	.addChildrenTo("gridTabs", ["prodList","prodEditList"]) 				 		
	 	.addToolbarTo("canvas1","tlbList")	  	
	 	.addToolbarTo("prodEdit","tlbEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbList", {dc:"prod"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Products"}).end()
			.beginToolbar("tlbEdit", {dc:"prod"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"Product"}).end(); 	
	}

});  
