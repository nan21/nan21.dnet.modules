Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/RoleDs", "nan21.dnet.module.ad.ui.extjs/dc/Role","nan21.dnet.module.ad.ui.extjs/asgn/RolesOfUser","nan21.dnet.module.ad.ui.extjs/asgn/RolesOfAccessControl"]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.Role_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Role_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("rol", new net.nan21.dnet.module.ad.usr.dc.Role({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnAsgnRoleToUsers",text:"Users", tooltip:"Assign selected role to users",disabled:true
			,handler: this.onBtnAsgnRoleToUsers,scope:this,stateManager:{name:"selected_one_clean", dc:"rol" }	})	
							 	
		.addButton({name:"btnAsgnRoleToAccessCtrl",text:"Access rights", tooltip:"Assign access rights to the selected role",disabled:true
			,handler: this.onBtnAsgnRoleToAccessCtrl,scope:this,stateManager:{name:"selected_one_clean", dc:"rol" }	})	
							 	
		.addDcFilterFormView("rol",{ name:"rolFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.Role$Filter"})	 
		.addDcView("rol",{ name:"rolList", xtype:"net.nan21.dnet.module.ad.usr.dc.Role$EditList", frame:true,buttons:[ this._elems_.get("btnAsgnRoleToUsers") ,this._elems_.get("btnAsgnRoleToAccessCtrl") ]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
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
			.beginToolbar("tlbRolList", {dc:"rol"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"List"}).end(); 	
	}


	,onBtnAsgnRoleToUsers: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Ui ,{dc:"rol",objectIdField:"id"});
	}					 	

	,onBtnAsgnRoleToAccessCtrl: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Ui ,{dc:"rol",objectIdField:"id"});
	}					 	
});
Ext.reg("net.nan21.dnet.module.ad.usr.frame.Role_UI", net.nan21.dnet.module.ad.usr.frame.Role_UI);   
