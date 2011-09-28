Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/UserDs", "nan21.dnet.module.ad.ui.extjs/dc/User","nan21.dnet.module.ad.ui.extjs/ds/UserTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/UserTypes","nan21.dnet.module.ad.ui.extjs/ds/UserTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/UserTypes","nan21.dnet.module.ad.ui.extjs/asgn/UserRoles","nan21.dnet.module.ad.ui.extjs/asgn/UserUserGroups"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.Users_UI", {  
	extend: "dnet.base.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.Users_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Users_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("usr", new net.nan21.dnet.module.ad.usr.dc.User())		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnAsgnRoles",text:"Roles", tooltip:"Assign roles",disabled:true
			,handler: this.onBtnAsgnRoles,scope:this,stateManager:{name:"record_is_clean", dc:"usr" }	})	
							 	
		.addButton({name:"btnAsgnGroups",text:"Groups", tooltip:"Add to user-groups",disabled:true
			,handler: this.onBtnAsgnGroups,scope:this,stateManager:{name:"record_is_clean", dc:"usr" }	})	
							 	
		.addDcFilterFormView("usr",{ name:"usrFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.User$Filter"})	 
		.addDcView("usr",{ name:"usrList", xtype:"net.nan21.dnet.module.ad.usr.dc.User$List"})	 
		.addDcFormView("usr",{ name:"usrEdit", xtype:"net.nan21.dnet.module.ad.usr.dc.User$Edit",buttons:{ xtype:"toolbar", weight:-1, items:[ this._elems_.get("btnAsgnRoles") ,this._elems_.get("btnAsgnGroups") ]}})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",preventHeader:true})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",preventHeader:true})  	 
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
			.beginToolbar("tlbUsrList", {dc:"usr"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().addSeparator().addSeparator().addTitle({"text":"List"}).end()
			.beginToolbar("tlbUsrEdit", {dc:"usr"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().addSeparator().addSeparator().addTitle({"text":"Editor"}).end(); 	
	}


	,onBtnAsgnRoles: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui ,{dc:"usr",objectIdField:"id"});
	}					 	

	,onBtnAsgnGroups: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Ui ,{dc:"usr",objectIdField:"id"});
	}					 	
});  
