Ext.ns("net.nan21.dnet.module.ad.usr.asgn");
net.nan21.dnet.module.ad.usr.asgn.RolesOfUser = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "RolesOfUser", 
	recordFields : [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});	 
 
net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"Code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Left", net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$List);
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Right", net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$List); 

net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,title:"Assign users to role"
	,_controller_:net.nan21.dnet.module.ad.usr.asgn.RolesOfUser
	,_filterFields_: [["id","Id"],["code","Code"],["name","Name"]]
	,_defaultFilterField_ : "code" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Ui", net.nan21.dnet.module.ad.usr.asgn.RolesOfUser$Ui);