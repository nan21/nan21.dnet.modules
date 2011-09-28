	
Ext.define("net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers", {
	extend: "dnet.base.AbstractAsgn",
	dsName: "UserGroupUsers", 
	recordModel: "net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Model"
});	 
 
Ext.define("net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$List", {
	extend: "dnet.base.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Left","widget.net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"Code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Ui", {
	extend: "dnet.base.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Ui",
 	 width:700
	,height:400 
	,title:"Assign users to group"
	,_controller_:net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers
	,_filterFields_: [["id","Id"],["code","Code"],["name","Name"]]
	,_defaultFilterField_ : "code" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Right"})
	}
});	 
