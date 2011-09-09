Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/UserTypeDs", "nan21.dnet.module.ad.ui.extjs/dc/UserType"]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.UserTypes_UI = Ext.extend( dnet.base.AbstractUi, {  
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
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},header:false})  	 
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
Ext.reg("net.nan21.dnet.module.ad.usr.frame.UserTypes_UI", net.nan21.dnet.module.ad.usr.frame.UserTypes_UI);   
