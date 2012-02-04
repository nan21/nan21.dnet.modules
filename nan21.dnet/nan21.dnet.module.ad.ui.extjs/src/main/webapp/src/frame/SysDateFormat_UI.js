Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/SysDateFormatDs", "nan21.dnet.module.ad.ui.extjs/dc/SysDateFormat"]);

Ext.define("net.nan21.dnet.module.ad.system.frame.SysDateFormat_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.system.frame.SysDateFormat_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.system.frame.SysDateFormat_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("fmt", new net.nan21.dnet.module.ad.system.dc.SysDateFormat({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("fmt",{ name:"fmtFilter", xtype:"net.nan21.dnet.module.ad.system.dc.SysDateFormat$Filter",height:120})	 
		.addDcView("fmt",{ name:"fmtEditList", xtype:"net.nan21.dnet.module.ad.system.dc.SysDateFormat$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["fmtFilter","fmtEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbFmtEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbFmtEditList", {dc:"fmt"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Date formats"}).end(); 	
	}

});  
