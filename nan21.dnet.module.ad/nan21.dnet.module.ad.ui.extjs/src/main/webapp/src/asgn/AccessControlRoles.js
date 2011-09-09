Ext.ns("net.nan21.dnet.module.ad.usr.asgn");
net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "AccessControlRoles", 
	recordFields : [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});	 
 
net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"description", dataIndex:"description", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Left", net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$List);
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Right", net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$List); 

net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,title:"Assign roles to privilege"
	,_controller_:net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Ui", net.nan21.dnet.module.ad.usr.asgn.AccessControlRoles$Ui);