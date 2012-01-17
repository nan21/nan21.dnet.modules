Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductCategoryDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductCategory","nan21.dnet.module.mm.ui.extjs/asgn/ProductsOfCategory"]);

Ext.define("net.nan21.dnet.module.mm.md.frame.ProductCategory_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.md.frame.ProductCategory_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.md.frame.ProductCategory_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("categ", new net.nan21.dnet.module.mm.md.dc.ProductCategory({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnAsgnCategories",text:"Assign Products", tooltip:"Add products to selected category",disabled:true
			,handler: this.onBtnAsgnCategories,scope:this,stateManager:{name:"selected_one_clean", dc:"categ" , and: function(evnt) {return ( !evnt.dc.record.data.folder );}}	})	
							 	
		.addDcFilterFormView("categ",{ name:"categFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductCategory$Filter",height:120})	 
		.addDcView("categ",{ name:"categEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductCategory$EditList", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAsgnCategories") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Categories",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCateg"]) 				 		
		.addChildrenTo("canvasCateg",["categFilter","categEditList"] ,["north","center"])	
	 	.addToolbarTo("canvasCateg","tlbCateg")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCateg", {dc:"categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Categories"}).end(); 	
	}


	,onBtnAsgnCategories: function() {
		this.showAsgnWindow(net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Ui ,{dc:"categ",objectIdField:"id"});
	}					 	
});  
