Ext.ns("net.nan21.dnet.module.ad.usr.asgn");
net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "RolesOfAccessControl", 
	recordFields : [{name:"id",type:"string"},{name:"name",type:"string"}]
});	 
 
net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Left", net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$List);
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Right", net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$List); 

net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,title:"Assign privileges to role"
	,_controller_:net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl
	,_filterFields_: [["id","Id"],["name","Name"]]
	,_defaultFilterField_ : "name" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Ui", net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Ui);