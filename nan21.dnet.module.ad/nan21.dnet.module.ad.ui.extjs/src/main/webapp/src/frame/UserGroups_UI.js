Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/UserGroupDs", "nan21.dnet.module.ad.ui.extjs/dc/UserGroup"
,"nan21.dnet.module.ad.ui.extjs/asgn/UserGroupUsers"
]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.UserGroups_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.UserGroups_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("dcGroup", new net.nan21.dnet.module.ad.usr.dc.UserGroup({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
		.addButton({name:"btnAsgnUsers",text:"Users in group", tooltip:"Add users to selected group",disabled:true
			,handler: this.onBtnAsgnUsers,scope:this,stateManager:{name:"selected_one", dc:"dcGroup"}	})	
							 	
		.addDcView("dcGroup",{ name:"filterGroup", xtype:"net.nan21.dnet.module.ad.usr.dc.UserGroup$Filter"})	 
		.addDcView("dcGroup",{ name:"elistGroup", xtype:"net.nan21.dnet.module.ad.usr.dc.UserGroup$EditList", frame:true,buttons:[ this._elems_.get("btnAsgnUsers") ]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["filterGroup","elistGroup"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbGroupEditList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbGroupEditList", {dc:"dcGroup"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}


	,onBtnAsgnUsers: function() {
		this.showAsgnWindow(net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Ui ,{dc:"dcGroup",objectIdField:"id"});
	}					 	
});
Ext.reg("net.nan21.dnet.module.ad.usr.frame.UserGroups_UI", net.nan21.dnet.module.ad.usr.frame.UserGroups_UI);   
