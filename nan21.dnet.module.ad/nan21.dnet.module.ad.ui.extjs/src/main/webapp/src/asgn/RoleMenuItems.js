	
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"},{name:"title",type:"string"}]
});
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems", {
	extend: "dnet.core.asgn.AbstractAsgn",
	dsName: "RoleMenuItems", 
	recordModel: "net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$Model"
});	 
 
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$Left","widget.net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"title", header:"Title", dataIndex:"title", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
		 
 	width:700,
	height:400,
	title:"Assign menu-items to role",

	_controller_:net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems,
	_filterFields_: [["id","Id"],["name","Name"],["title","Title"]],
	_defaultFilterField_ : "name", 

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.RoleMenuItems$Right"})
	}
});	 
