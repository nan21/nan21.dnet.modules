	
Ext.define("net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems", {
	extend: "dnet.base.AbstractAsgn",
	dsName: "OrganizationHierarchyItems", 
	recordModel: "net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$Model"
});	 
 
Ext.define("net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$List", {
	extend: "dnet.base.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$Left","widget.net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"Code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$Ui", {
	extend: "dnet.base.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$Ui",
 	 width:500
	,height:300 
	,title:"User roles"
	,_controller_:net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems
	,_filterFields_: [["id","Id"],["code","Code"],["name","Name"]]
	,_defaultFilterField_ : "code" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.bd.org.asgn.OrganizationHierarchyItems$Right"})
	}
});	 
