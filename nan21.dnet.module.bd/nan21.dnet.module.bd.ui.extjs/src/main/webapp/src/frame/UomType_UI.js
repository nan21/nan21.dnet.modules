Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/UomTypeDs", "nan21.dnet.module.bd.ui.extjs/dc/UomType"]);

Ext.ns("net.nan21.dnet.module.bd.uom.frame");
net.nan21.dnet.module.bd.uom.frame.UomType_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bd.uom.frame.UomType_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("type", new net.nan21.dnet.module.bd.uom.dc.UomType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("type",{ name:"typeFilter", xtype:"net.nan21.dnet.module.bd.uom.dc.UomType$Filter"})	 
		.addDcView("type",{ name:"typeEditList", xtype:"net.nan21.dnet.module.bd.uom.dc.UomType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},header:false})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["typeFilter","typeEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbTypeEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbTypeEditList", {dc:"type"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.bd.uom.frame.UomType_UI", net.nan21.dnet.module.bd.uom.frame.UomType_UI);   
