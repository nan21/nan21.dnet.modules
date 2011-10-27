Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/UomDs", "nan21.dnet.module.bd.ui.extjs/dc/Uom", "nan21.dnet.module.bd.ui.extjs/ds/UomConversionDs", "nan21.dnet.module.bd.ui.extjs/dc/UomConversion","nan21.dnet.module.bd.ui.extjs/ds/UomTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomType","nan21.dnet.module.bd.ui.extjs/ds/UomTypeLovDs","nan21.dnet.module.bd.ui.extjs/lov/UomType","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure"]);

Ext.define("net.nan21.dnet.module.bd.uom.frame.UomMD_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.uom.frame.UomMD_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.uom.frame.UomMD_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("uom", new net.nan21.dnet.module.bd.uom.dc.Uom({}))
		.addDc("cnv", new net.nan21.dnet.module.bd.uom.dc.UomConversion({multiEdit:true}))		
		.linkDc("cnv", "uom",{fields:[ {childField:"sourceId", parentField:"id"},{childField:"sourceCode", parentField:"code"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("uom",{ name:"uomFilter", xtype:"net.nan21.dnet.module.bd.uom.dc.Uom$Filter",height:80})	 
		.addDcView("uom",{ name:"uomList", xtype:"net.nan21.dnet.module.bd.uom.dc.Uom$List"})	 
		.addDcFormView("uom",{ name:"uomEdit", xtype:"net.nan21.dnet.module.bd.uom.dc.Uom$Edit",height:125})	 
		.addDcView("cnv",{ name:"cnvEditList", xtype:"net.nan21.dnet.module.bd.uom.dc.UomConversion$CtxEditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["uomFilter","uomList"] ,["north","center"])	
		.addChildrenTo("canvas2",["uomEdit","cnvEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbUomList")	  	
	 	.addToolbarTo("canvas2","tlbUomEdit")	  	
	 	.addToolbarTo("cnvEditList","tlbCnvEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbUomList", {dc:"uom"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbUomEdit", {dc:"uom"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end()
			.beginToolbar("tlbCnvEditList", {dc:"cnv"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}

});  
