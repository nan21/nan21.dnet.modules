Dnet.doImport(["", "nan21.dnet.module.mm.ui.extjs/ds/ProductAttachmentDs", "nan21.dnet.module.mm.ui.extjs/dc/ProductAttachment","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes","nan21.dnet.module.mm.ui.extjs/ds/ProductLovDs","nan21.dnet.module.mm.ui.extjs/lov/Products","nan21.dnet.module.ad.ui.extjs/ds/AttachmentTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/AttachmentTypes"]);

Ext.define("net.nan21.dnet.module.mm.md.frame.ProductAttachment_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.mm.md.frame.ProductAttachment_UI",
	
	 _name_ : "net.nan21.dnet.module.mm.md.frame.ProductAttachment_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("attch", new net.nan21.dnet.module.mm.md.dc.ProductAttachment({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("attch",{ name:"attchFilter", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttachment$Filter",height:120})	 
		.addDcView("attch",{ name:"attchEditList", xtype:"net.nan21.dnet.module.mm.md.dc.ProductAttachment$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["attchFilter","attchEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbAttchEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAttchEditList", {dc:"attch"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});  
