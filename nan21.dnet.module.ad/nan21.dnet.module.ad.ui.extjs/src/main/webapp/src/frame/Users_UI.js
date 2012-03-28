Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/UserDs", "nan21.dnet.module.ad.ui.extjs/dc/User","nan21.dnet.module.ad.ui.extjs/ds/UserTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/UserTypes","nan21.dnet.module.ad.ui.extjs/ds/SysDateFormatLovDs","nan21.dnet.module.ad.ui.extjs/lov/SysDateFormats","nan21.dnet.module.ad.ui.extjs/ds/UserTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/UserTypes","nan21.dnet.module.ad.ui.extjs/ds/RoleLovDs","nan21.dnet.module.ad.ui.extjs/lov/Roles","nan21.dnet.module.ad.ui.extjs/ds/UserGroupLovDs","nan21.dnet.module.ad.ui.extjs/lov/UserGroups","nan21.dnet.module.ad.ui.extjs/asgn/UserRoles","nan21.dnet.module.ad.ui.extjs/asgn/UserUserGroups"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.Users_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.Users_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Users_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("usr", new net.nan21.dnet.module.ad.usr.dc.User({}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnAsgnRoles",text:"Roles", tooltip:"Assign roles",disabled:true
			,handler: this.onBtnAsgnRoles,scope:this,stateManager:{name:"record_is_clean", dc:"usr" }	})	
							 	
		.addButton({name:"btnAsgnGroups",text:"Groups", tooltip:"Add to user-groups",disabled:true
			,handler: this.onBtnAsgnGroups,scope:this,stateManager:{name:"record_is_clean", dc:"usr" }	})	
							 	
		.addButton({name:"btnChangePassword",text:"Change password", tooltip:"Change the user`s password",disabled:true
			,handler: this.onBtnChangePassword,scope:this,stateManager:{name:"record_is_clean", dc:"usr" }	})	
							 	
		.addButton({name:"btnSavePassword",text:"Save", tooltip:"Save new password",disabled:false
			,handler: this.onBtnSavePassword,scope:this	})	
							 	
		.addButton({name:"btnCreateAssignable",text:"Create assignable", tooltip:"Create assignable resource record",disabled:true
			,handler: this.onBtnCreateAssignable,scope:this,stateManager:{name:"record_is_clean", dc:"usr" }	})	
							 	
		.addDcFilterFormView("usr",{ name:"usrFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.User$Filter",height:140})	 
		.addDcGridView("usr",{ name:"usrList", xtype:"net.nan21.dnet.module.ad.usr.dc.User$List"})	 
		.addDcFormView("usr",{ name:"usrEdit", xtype:"net.nan21.dnet.module.ad.usr.dc.User$Edit",dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAsgnRoles") ,this._elems_.get("btnAsgnGroups") ,this._elems_.get("btnChangePassword") ,this._elems_.get("btnCreateAssignable") ]}]})	 
		.addDcFormView("usr",{ name:"canvasPassword", xtype:"net.nan21.dnet.module.ad.usr.dc.User$ChangePasswordForm"})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},preventHeader:true})  	 
		
		.addWindow({name:"wdwChangePassword", closeAction:'hide', resizable:true, layout:"fit", items:[this._elems_.get("canvasPassword")]
,title:"Change password",modal:true,buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnSavePassword") ]}}) 	
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["usrFilter","usrList"] ,["north","center"])	
		.addChildrenTo("canvas2",["usrEdit"] ,["center"])	
	 	.addToolbarTo("canvas1","tlbUsrList")	  	
	 	.addToolbarTo("canvas2","tlbUsrEdit")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbUsrList", {dc:"usr"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addReports().addSeparator().addSeparator().addTitle({"text":"Users"}).end()
			.beginToolbar("tlbUsrEdit", {dc:"usr"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addReports().addSeparator().addSeparator().addTitle({"text":"User"}).end(); 	
	}


	,onBtnAsgnRoles: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui ,{dc:"usr",objectIdField:"id"});
	}					 	

	,onBtnAsgnGroups: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Ui ,{dc:"usr",objectIdField:"id"});
	}					 	

	,onBtnChangePassword: function() {
		this._getWindow_("wdwChangePassword").show();			 	
	}					 	

	,onBtnSavePassword: function() {
		var s={modal:true, callbacks:{} };
		var successFn = function(dc,response,serviceName,specs) { 			this._getWindow_("wdwChangePassword").close();			 	
			}; 
		s.callbacks['successFn'] = successFn; 
		s.callbacks['successScope'] = this;
		try{ 
			this._getDc_("usr").doService("changePassword", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	

	,onBtnCreateAssignable: function() {
		var s={modal:true, callbacks:{} };
		try{ 
			this._getDc_("usr").doService("createAssignableResource", s); 
		}catch(e){
			dnet.base.DcExceptions.showMessage(e);
		}
	}					 	
});  
