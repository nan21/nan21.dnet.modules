Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/DsMethodAccessControlDs", "nan21.dnet.module.ad.ui.extjs/dc/DsMethodAccessControl","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceDsLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceDs","nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs","nan21.dnet.module.ad.ui.extjs/lov/AccessControls","nan21.dnet.module.ad.ui.extjs/ds/AccessControlLovDs","nan21.dnet.module.ad.ui.extjs/lov/AccessControls","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceDsLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSourceDs","nan21.dnet.module.ad.ui.extjs/ds/SysDsServiceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDsServices"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.DsMethodAccessControl_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.DsMethodAccessControl_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.DsMethodAccessControl_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dsAccess", new net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("dsAccess",{ name:"dsAccessFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$Filter",height:80})	 
		.addDcEditGridView("dsAccess",{ name:"dsAccessEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.DsMethodAccessControl$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["dsAccessFilter","dsAccessEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbDsAccessEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbDsAccessEditList", {dc:"dsAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"DS method rules"}).end(); 	
	}

});  
