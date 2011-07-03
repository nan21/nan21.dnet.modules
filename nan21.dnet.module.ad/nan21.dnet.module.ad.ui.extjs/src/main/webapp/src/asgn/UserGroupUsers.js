Ext.ns("net.nan21.dnet.module.ad.usr.asgn");
net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "UserGroupUsers", 
	recordFields : [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});	 
 
net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"name", dataIndex:"name", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Left", net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$List);
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Right", net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$List); 

net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,_controller_:net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Ui", net.nan21.dnet.module.ad.usr.asgn.UserGroupUsers$Ui);