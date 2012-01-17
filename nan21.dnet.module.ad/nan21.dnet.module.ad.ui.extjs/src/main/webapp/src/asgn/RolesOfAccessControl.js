	
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl", {
	extend: "dnet.core.asgn.AbstractAsgn",
	dsName: "RolesOfAccessControl", 
	recordModel: "net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Model"
});	 
 
Ext.define("net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Left","widget.net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.ad.usr.asgn.RolesOfAccessControl$Ui",
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
