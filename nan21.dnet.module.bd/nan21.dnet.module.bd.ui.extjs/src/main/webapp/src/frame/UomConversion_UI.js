Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/UomConversionDs", "nan21.dnet.module.bd.ui.extjs/dc/UomConversion","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure","nan21.dnet.module.bd.ui.extjs/ds/UomLovDs","nan21.dnet.module.bd.ui.extjs/lov/UnitsOfMeasure"]);

Ext.define("net.nan21.dnet.module.bd.uom.frame.UomConversion_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.uom.frame.UomConversion_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.uom.frame.UomConversion_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.bd.uom.dc.UomConversion({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("m",{ name:"mFilter", xtype:"net.nan21.dnet.module.bd.uom.dc.UomConversion$Filter",height:80})	 
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.bd.uom.dc.UomConversion$EditList", frame:true})	 
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
