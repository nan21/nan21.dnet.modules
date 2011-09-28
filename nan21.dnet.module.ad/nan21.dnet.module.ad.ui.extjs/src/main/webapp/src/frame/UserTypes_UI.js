Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/UserTypeDs", "nan21.dnet.module.ad.ui.extjs/dc/UserType"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.UserTypes_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.UserTypes_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.UserTypes_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("userType", new net.nan21.dnet.module.ad.usr.dc.UserType({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("userType",{ name:"filterUserType", xtype:"net.nan21.dnet.module.ad.usr.dc.UserType$Filter"})	 
		.addDcView("userType",{ name:"listUserType", xtype:"net.nan21.dnet.module.ad.usr.dc.UserType$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["filterUserType","listUserType"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbGroupEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbGroupEditList", {dc:"userType"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});  
