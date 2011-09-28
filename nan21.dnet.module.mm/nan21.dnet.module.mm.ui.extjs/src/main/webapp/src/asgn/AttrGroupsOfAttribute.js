	
Ext.define("net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});
Ext.define("net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute", {
	extend: "dnet.base.AbstractAsgn",
	dsName: "AttrGroupsOfAttribute", 
	recordModel: "net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Model"
});	 
 
Ext.define("net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$List", {
	extend: "dnet.base.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Left","widget.net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"Description", dataIndex:"description", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Ui", {
	extend: "dnet.base.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Ui",
 	 width:700
	,height:400 
	,title:"Assign groups to attribute"
	,_controller_:net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute
	,_filterFields_: [["id","Id"],["name","Name"]]
	,_defaultFilterField_ : "name" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Right"})
	}
});	 
