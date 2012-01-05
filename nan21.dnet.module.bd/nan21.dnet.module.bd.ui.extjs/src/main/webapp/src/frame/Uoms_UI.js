Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/UomDs", "nan21.dnet.module.bd.ui.extjs/dc/Uom","nan21.dnet.module.bd.ui.extjs/ds/UomTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomType","nan21.dnet.module.bd.ui.extjs/ds/UomTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomType"]);

Ext.define("net.nan21.dnet.module.bd.uom.frame.Uoms_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.uom.frame.Uoms_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.uom.frame.Uoms_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.bd.uom.dc.Uom({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.bd.uom.dc.Uom$Filter",height:120})	 
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.bd.uom.dc.Uom$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mFilter","mEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbMEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Edit list"}).end(); 	
	}

});  
