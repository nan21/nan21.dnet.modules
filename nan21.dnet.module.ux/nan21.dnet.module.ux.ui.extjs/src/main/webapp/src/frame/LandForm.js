Dnet.doImport(["", "nan21.dnet.module.ux.ui.extjs/ds/LandFormDs", "nan21.dnet.module.ux.ui.extjs/dc/LandForm","nan21.dnet.module.bd.ui.extjs/ds/CountryLovDs","nan21.dnet.module.bd.ui.extjs/lov/Countries"]);

Ext.define("net.nan21.dnet.module.ux.example.frame.LandForm", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ux.example.frame.LandForm",
	
	 _name_ : "net.nan21.dnet.module.ux.example.frame.LandForm"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("m", new net.nan21.dnet.module.ux.example.dc.LandForm({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcView("m",{ name:"mEditList", xtype:"net.nan21.dnet.module.ux.example.dc.LandForm$EditListCtx", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Edit list",preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["mEditList"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbMEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbMEditList", {dc:"m"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Edit list"}).end(); 	
	}

});  
