Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/AttributeCategoryDs", "nan21.dnet.module.bd.ui.extjs/dc/AttributeCategory"]);

Ext.define("net.nan21.dnet.module.bd.attr.frame.AttributeBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.attr.frame.AttributeBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.attr.frame.AttributeBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("categ", new net.nan21.dnet.module.bd.attr.dc.AttributeCategory({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("categ",{ name:"categFilter", xtype:"net.nan21.dnet.module.bd.attr.dc.AttributeCategory$Filter",height:120})	 
		.addDcEditGridView("categ",{ name:"categEditList", xtype:"net.nan21.dnet.module.bd.attr.dc.AttributeCategory$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasCateg", layout:"border", defaults:{split:true},title:"Attribute categories",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasCateg"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasCateg"]) 				 		
		.addChildrenTo("canvasCateg",["categFilter","categEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasCateg","tlbCategEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCategEditList", {dc:"categ"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Attribute categories"}).end(); 	
	}

});  
