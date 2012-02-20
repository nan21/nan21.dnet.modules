Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductManufacturer"]);

Ext.define("net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("manufact", new net.nan21.dnet.module.mm.md.dc.ProductManufacturer({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("manufact",{ name:"manufactFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductManufacturer$Filter",height:120})	 
		.addDcEditGridView("manufact",{ name:"manufactEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductManufacturer$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasManufact", layout:"border", defaults:{split:true},title:"Manufacturers",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasManufact"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasManufact"]) 				 		
		.addChildrenTo("canvasManufact",["manufactFilter","manufactEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasManufact","tlbManufact")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbManufact", {dc:"manufact"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Manufacturers"}).end(); 	
	}

});  
