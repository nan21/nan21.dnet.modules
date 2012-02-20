Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/RoleDs", "nan21.dnet.module.ad.ui.extjs/dc/Role","nan21.dnet.module.ad.ui.extjs/asgn/RolesOfUser","nan21.dnet.module.ad.ui.extjs/asgn/RolesOfAccessControl","nan21.dnet.module.ad.ui.extjs/asgn/RoleMenuItems","nan21.dnet.module.ad.ui.extjs/asgn/RoleMenus"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.Role_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.Role_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Role_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("rol", new net.nan21.dnet.module.ad.usr.dc.Role({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnAsgnRoleToUsers",text:"Users", tooltip:"Assign users to the selected role",disabled:true
			,handler: this.onBtnAsgnRoleToUsers,scope:this,stateManager:{name:"selected_one_clean", dc:"rol" }	})	
							 	
		.addButton({name:"btnAsgnRoleToAccessCtrl",text:"Privileges", tooltip:"Assign privileges to the selected role",disabled:true
			,handler: this.onBtnAsgnRoleToAccessCtrl,scope:this,stateManager:{name:"selected_one_clean", dc:"rol" }	})	
							 	
		.addButton({name:"btnAsgnRoleToMenuItem",text:"Menu items", tooltip:"Assign menu items to the selected role",disabled:true
			,handler: this.onBtnAsgnRoleToMenuItem,scope:this,stateManager:{name:"selected_one_clean", dc:"rol" }	})	
							 	
		.addButton({name:"btnAsgnRoleToMenu",text:"Menus", tooltip:"Assign menus to the selected role",disabled:true
			,handler: this.onBtnAsgnRoleToMenu,scope:this,stateManager:{name:"selected_one_clean", dc:"rol" }	})	
							 	
		.addDcFilterFormView("rol",{ name:"rolFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.Role$Filter",height:120})	 
		.addDcEditGridView("rol",{ name:"rolList", xtype:"net.nan21.dnet.module.ad.usr.dc.Role$EditList", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAsgnRoleToUsers") ,this._elems_.get("btnAsgnRoleToAccessCtrl") ,this._elems_.get("btnAsgnRoleToMenu") ,this._elems_.get("btnAsgnRoleToMenuItem") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["rolFilter","rolList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbRolList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbRolList", {dc:"rol"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Roles"}).end(); 	
	}


	,onBtnAsgnRoleToUsers: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Ui ,{dc:"rol",objectIdField:"id"});
	}					 	

	,onBtnAsgnRoleToAccessCtrl: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Ui ,{dc:"rol",objectIdField:"id"});
	}					 	

	,onBtnAsgnRoleToMenuItem: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$Ui ,{dc:"rol",objectIdField:"id"});
	}					 	

	,onBtnAsgnRoleToMenu: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.RoleMenus$Ui ,{dc:"rol",objectIdField:"id"});
	}					 	
});  
