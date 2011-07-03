Dnet.import(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductDs", "nan21.dnet.module.mm.ui.extjs/dc/Product","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductCategories","nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerLovDs","nan21.dnet.module.mm.ui.extjs/lov/ProductManufacturers"]);

Ext.ns("net.nan21.dnet.module.mm.md.frame");
net.nan21.dnet.module.mm.md.frame.Product_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.mm.md.frame.Product_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("prod", new net.nan21.dnet.module.mm.md.dc.Product())		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addDcView("prod",{ name:"prodFilter", xtype:"net.nan21.dnet.module.mm.md.dc.Product$Filter"})	 
		.addDcView("prod",{ name:"prodList", xtype:"net.nan21.dnet.module.mm.md.dc.Product$List"})	 
		.addDcView("prod",{ name:"prodEdit", xtype:"net.nan21.dnet.module.mm.md.dc.Product$Edit",height:150})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["prodFilter","prodList"] ,["north","center"])	
		.addChildrenTo("canvas2",["prodEdit"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbProdList")	  	
	 	.addToolbarTo("canvas2","tlbProdEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbProdList", {dc:"prod"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbProdEdit", {dc:"prod"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.mm.md.frame.Product_UI", net.nan21.dnet.module.mm.md.frame.Product_UI);   
