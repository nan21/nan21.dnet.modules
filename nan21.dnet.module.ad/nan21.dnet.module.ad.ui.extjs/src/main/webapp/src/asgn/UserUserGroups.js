Ext.ns("net.nan21.dnet.module.ad.usr.asgn");
net.nan21.dnet.module.ad.usr.asgn.UserUserGroups = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "UserUserGroups", 
	recordFields : [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});	 
 
net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"description", dataIndex:"description", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Left", net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$List);
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Right", net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$List); 

net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,_controller_:net.nan21.dnet.module.ad.usr.asgn.UserUserGroups
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Ui", net.nan21.dnet.module.ad.usr.asgn.UserUserGroups$Ui);