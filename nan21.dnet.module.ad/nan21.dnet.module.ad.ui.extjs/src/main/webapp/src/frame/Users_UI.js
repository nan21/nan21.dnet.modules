Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/UserDs", "nan21.dnet.module.ad.ui.extjs/dc/User"]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.Users_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Users_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("usr", new net.nan21.dnet.module.ad.usr.dc.User())		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
			.addButton({xtype:"button", name:"btnAsgnRoles", id:Ext.id() 
					,text:"Roles", tooltip:"Assign roles"
					,disabled:true
					,handler: function() {}  ,scope:this })	
							 	
			.addButton({xtype:"button", name:"btnAsgnGroups", id:Ext.id() 
					,text:"Groups", tooltip:"Add to user-groups"
					,disabled:true
					,handler: function() {}  ,scope:this })	
							 	
		.addDcView("usr",{ name:"usrFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.User$Filter"})	 
		.addDcView("usr",{ name:"usrList", xtype:"net.nan21.dnet.module.ad.usr.dc.User$List"})	 
		.addDcView("usr",{ name:"usrEdit", xtype:"net.nan21.dnet.module.ad.usr.dc.User$Edit",buttons:[ this._elems_.get("btnAsgnRoles") ,this._elems_.get("btnAsgnGroups") ]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Editor",header:false})  	 
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
			.beginToolbar("tlbUsrList", {dc:"usr"}).addQuery().addEdit().addNew().addCopy().addDeleteSelected().end()
			.beginToolbar("tlbUsrEdit", {dc:"usr"}).addBack().addSave().addNew().addCopy().addCancel().addPrevRec().addNextRec().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.ad.usr.frame.Users_UI", net.nan21.dnet.module.ad.usr.frame.Users_UI);   
