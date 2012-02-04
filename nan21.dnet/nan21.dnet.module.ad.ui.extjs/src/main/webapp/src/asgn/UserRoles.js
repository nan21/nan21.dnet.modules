	
Ext.define("net.nan21.dnet.module.ad.usr.asgn.UserRoles$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});
Ext.define("net.nan21.dnet.module.ad.usr.asgn.UserRoles", {
	extend: "dnet.core.asgn.AbstractAsgn",
	dsName: "UserRoles", 
	recordModel: "net.nan21.dnet.module.ad.usr.asgn.UserRoles$Model"
});	 
 
Ext.define("net.nan21.dnet.module.ad.usr.asgn.UserRoles$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.ad.usr.asgn.UserRoles$Left","widget.net.nan21.dnet.module.ad.usr.asgn.UserRoles$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"Description", dataIndex:"description", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui",
 	 width:700
	,height:400 
	,title:"Assign roles to user"
	,_controller_:net.nan21.dnet.module.ad.usr.asgn.UserRoles
	,_filterFields_: [["id","Id"],["name","Name"]]
	,_defaultFilterField_ : "name" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserRoles$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserRoles$Right"})
	}
});	 
