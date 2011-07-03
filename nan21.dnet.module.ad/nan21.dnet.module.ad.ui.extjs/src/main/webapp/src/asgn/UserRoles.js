Ext.ns("net.nan21.dnet.module.ad.usr.asgn");
net.nan21.dnet.module.ad.usr.asgn.UserRoles = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "UserRoles", 
	recordFields : [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});	 
 
net.nan21.dnet.module.ad.usr.asgn.UserRoles$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"description", dataIndex:"description", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserRoles$Left", net.nan21.dnet.module.ad.usr.asgn.UserRoles$List);
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserRoles$Right", net.nan21.dnet.module.ad.usr.asgn.UserRoles$List); 

net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,_controller_:net.nan21.dnet.module.ad.usr.asgn.UserRoles
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserRoles$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserRoles$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui", net.nan21.dnet.module.ad.usr.asgn.UserRoles$Ui);