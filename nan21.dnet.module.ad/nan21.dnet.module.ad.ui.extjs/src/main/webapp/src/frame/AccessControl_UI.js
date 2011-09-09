Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/AccessControlDs", "nan21.dnet.module.ad.ui.extjs/dc/AccessControl", "nan21.dnet.module.ad.ui.extjs/ds/DsAccessControlDs", "nan21.dnet.module.ad.ui.extjs/dc/DsAccessControl","nan21.dnet.module.ad.ui.extjs/ds/SysDataSourceLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDataSource","nan21.dnet.module.ad.ui.extjs/asgn/AccessControlRoles"]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.AccessControl_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.AccessControl_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("ctrl", new net.nan21.dnet.module.ad.usr.dc.AccessControl({multiEdit:true}))
		.addDc("dsAccess", new net.nan21.dnet.module.ad.usr.dc.DsAccessControl({multiEdit:true}))		
		.linkDc("dsAccess", "ctrl",{fetchMode:"auto",fields:[ {childField:"accessControlId", parentField:"id"} ]} );		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnAsgnRoleToAccessCtrl",text:"Roles", tooltip:"Assign selected access right to roles",disabled:true
			,handler: this.onBtnAsgnRoleToAccessCtrl,scope:this,stateManager:{name:"selected_one_clean", dc:"ctrl" }	})	
							 	
		.addDcFilterFormView("ctrl",{ name:"privilegeFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.AccessControl$Filter"})	 
		.addDcView("ctrl",{ name:"privilegeEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.AccessControl$EditList", frame:true,buttons:[ this._elems_.get("btnAsgnRoleToAccessCtrl") ]})	 
		.addDcFilterFormView("dsAccess",{ name:"dsAccessFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.DsAccessControl$Filter"})	 
		.addDcView("dsAccess",{ name:"dsAccessCtxEditList", xtype:"net.nan21.dnet.module.ad.usr.dc.DsAccessControl$CtxEditList", frame:true,height:180})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},header:false})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["privilegeFilter","privilegeEditList","dsAccessCtxEditList"] ,["north","center","south"])	
	 	.addToolbarTo("canvas1","tlbCtrlEditList")	  	
	 	.addToolbarTo("dsAccessCtxEditList","tlbDsAccessCtxEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCtrlEditList", {dc:"ctrl"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("tlbDsAccessCtxEditList", {dc:"dsAccess"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addAutoLoad().end(); 	
	}


	,onBtnAsgnRoleToAccessCtrl: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Ui ,{dc:"ctrl",objectIdField:"id"});
	}					 	
});
Ext.reg("net.nan21.dnet.module.ad.usr.frame.AccessControl_UI", net.nan21.dnet.module.ad.usr.frame.AccessControl_UI);   
