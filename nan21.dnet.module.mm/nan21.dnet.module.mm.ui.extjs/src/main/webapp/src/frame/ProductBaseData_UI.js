Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttachmentTypeDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttachmentType", "nan21.dnet.module.mm.ui.extjs/ds/ProductManufacturerDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductManufacturer"]);

Ext.define("net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.md.frame.ProductBaseData_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("attachType", new net.nan21.dnet.module.mm.md.dc.ProductAttachmentType({multiEdit:true}))
		.addDc("manufact", new net.nan21.dnet.module.mm.md.dc.ProductManufacturer({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("attachType",{ name:"attachTypeFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttachmentType$Filter",height:80})	 
		.addDcView("attachType",{ name:"attachTypeEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttachmentType$EditList", frame:true})	 
		.addDcFilterFormView("manufact",{ name:"manufactFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductManufacturer$Filter",height:40})	 
		.addDcView("manufact",{ name:"manufactEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductManufacturer$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasAttachType", layout:"border", defaults:{split:true},title:"Attachment types",preventHeader:true})  	 
		.addPanel({name: "canvasManufact", layout:"border", defaults:{split:true},title:"Manufacturers",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasAttachType","canvasManufact"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasAttachType","canvasManufact"]) 				 		
		.addChildrenTo("canvasAttachType",["attachTypeFilter","attachTypeEditList"] ,["north","center"])	
		.addChildrenTo("canvasManufact",["manufactFilter","manufactEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasAttachType","tlbTypeEditList")	  	
	 	.addToolbarTo("canvasManufact","tlbManufact")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTypeEditList", {dc:"attachType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Attachment types"}).end()
			.beginToolbar("tlbManufact", {dc:"manufact"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Manufacturers"}).end(); 	
	}

});  
