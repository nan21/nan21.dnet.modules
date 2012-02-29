Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/AsgnAccessControlDs", "nan21.dnet.module.ad.ui.extjs/dc/AsgnAccessControl","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceAsgnLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceAsgn","nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs","nan21.dnet.module.ad.ui.extjs/lov/AccessControls","nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs","nan21.dnet.module.ad.ui.extjs/lov/AccessControls","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceAsgnLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceAsgn"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.AsgnAccessControl_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("asgnAccess", new net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("asgnAccess",{ name:"asgnAccessFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$Filter",height:120})	 
		.addDcEditGridView("asgnAccess",{ name:"asgnAccessEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.AsgnAccessControl$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["asgnAccessFilter","asgnAccessEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbAsgnAccessEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbAsgnAccessEditList", {dc:"asgnAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"ASGN rules"}).end(); 	
	}

});  
