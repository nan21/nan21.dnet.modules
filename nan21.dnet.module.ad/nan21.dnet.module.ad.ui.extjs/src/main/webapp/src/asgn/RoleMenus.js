	
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RoleMenus$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"},{name:"title",type:"string"}]
});
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RoleMenus", {
	extend: "dnet.core.asgn.AbstractAsgn",
	dsName: "RoleMenus", 
	recordModel: "net.nan21.dnet.module.ad.usr.asgn.RoleMenus$Model"
});	 
 
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RoleMenus$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.ad.usr.asgn.RoleMenus$Left","widget.net.nan21.dnet.module.ad.usr.asgn.RoleMenus$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"title", header:"Title", dataIndex:"title", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.ad.usr.asgn.RoleMenus$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
		 
 	width:700,
	height:400,
	title:"Assign menus to role",

	_controller_:net.nan21.dnet.module.ad.usr.asgn.RoleMenus,
	_filterFields_: [["id","Id"],["name","Name"],["title","Title"]],
	_defaultFilterField_ : "name", 

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.RoleMenus$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.RoleMenus$Right"})
	}
});	 
