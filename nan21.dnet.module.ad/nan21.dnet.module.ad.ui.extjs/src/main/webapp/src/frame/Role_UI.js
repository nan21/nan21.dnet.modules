Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/RoleDs", "nan21.dnet.module.ad.ui.extjs/dc/Role"]);

Ext.ns("net.nan21.dnet.module.ad.usr.frame");
net.nan21.dnet.module.ad.usr.frame.Role_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.usr.frame.Role_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("rol", new net.nan21.dnet.module.ad.usr.dc.Role({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
		this._getBuilder_()	
			.addButton({xtype:"button", name:"btnAsgnToUsers", id:Ext.id() 
					,text:"Users", tooltip:"Assign selected role to users"
					,disabled:true
					,handler: function() {}  ,scope:this })	
							 	
		.addDcView("rol",{ name:"rolFilter", xtype:"net.nan21.dnet.module.ad.usr.dc.Role$Filter"})	 
		.addDcView("rol",{ name:"rolList", xtype:"net.nan21.dnet.module.ad.usr.dc.Role$EditList", frame:true,buttons:[ this._elems_.get("btnAsgnToUsers") ]})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"List",header:false})  	 
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["rolFilter","rolList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbRolList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbRolList", {dc:"rol"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end();
	}

});
Ext.reg("net.nan21.dnet.module.ad.usr.frame.Role_UI", net.nan21.dnet.module.ad.usr.frame.Role_UI);   
