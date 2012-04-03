Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/SysFrameExtensionDs", "nan21.dnet.module.ad.ui.extjs/dc/SysFrameExtension"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysFrameExtension_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.system.frame.SysFrameExtension_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.system.frame.SysFrameExtension_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("extensions", new net.nan21.dnet.module.ad.system.dc.SysFrameExtension({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("extensions",{ name:"extensionsFilter", xtype:"net.nan21.dnet.module.ad.system.dc.SysFrameExtension$Filter"})	 
		.addDcEditGridView("extensions",{ name:"extensionsEditList", xtype:"net.nan21.dnet.module.ad.system.dc.SysFrameExtension$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["extensionsFilter","extensionsEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbExtensionsEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbExtensionsEditList", {dc:"extensions"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Frame extensions"}).end(); 	
	}

});  
