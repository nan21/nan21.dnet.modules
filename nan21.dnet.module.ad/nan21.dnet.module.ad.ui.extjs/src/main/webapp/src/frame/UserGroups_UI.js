Dnet.doImport(["", "nan21.dnet.module.ad.ui.extjs/ds/UserGroupDs", "nan21.dnet.module.ad.ui.extjs/dc/UserGroup","nan21.dnet.module.ad.ui.extjs/asgn/UserGroupUsers"]);

Ext.define("net.nan21.dnet.module.ad.usr.frame.UserGroups_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.ad.usr.frame.UserGroups_UI",
	
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.UserGroups_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcGroup", new net.nan21.dnet.module.ad.usr.dc.UserGroup({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addButton({name:"btnAsgnUsers",text:"Users in group", tooltip:"Add users to selected group",disabled:true
			,handler: this.onBtnAsgnUsers,scope:this,stateManager:{name:"selected_one_clean", dc:"dcGroup" }	})	
							 	
		.addDcFilterFormView("dcGroup",{ name:"filterGroup", xtype:"net.nan21.dnet.module.ad.usr.dc.UserGroup$Filter",height:120})	 
		.addDcEditGridView("dcGroup",{ name:"elistGroup", xtype:"net.nan21.dnet.module.ad.usr.dc.UserGroup$EditList", frame:true,dockedItems:[{ xtype:"toolbar", ui:"footer", dock: 'bottom', weight:-1, items:[ this._elems_.get("btnAsgnUsers") ]}]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["filterGroup","elistGroup"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbGroupEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbGroupEditList", {dc:"dcGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"User groups"}).end(); 	
	}


	,onBtnAsgnUsers: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Ui ,{dc:"dcGroup",objectIdField:"id"});
	}					 	
});  
