Ext.ns("net.nan21.dnet.module.ad.usr.asgn");
net.nan21.dnet.module.ad.usr.asgn.UserRoles = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "UserRoles", 
	recordFields : [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});	 
 
net.nan21.dnet.module.ad.usr.asgn.UserRoles$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"Description", dataIndex:"description", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserRoles$Left", net.nan21.dnet.module.ad.usr.asgn.UserRoles$List);
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserRoles$Right", net.nan21.dnet.module.ad.usr.asgn.UserRoles$List); 

net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
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
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui", net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui);