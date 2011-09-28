	
Ext.define("net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});
Ext.define("net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup", {
	extend: "dnet.base.AbstractAsgn",
	dsName: "AttributesOfAttrGroup", 
	recordModel: "net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Model"
});	 
 
Ext.define("net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$List", {
	extend: "dnet.base.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Left","widget.net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"Description", dataIndex:"description", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Ui", {
	extend: "dnet.base.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Ui",
 	 width:700
	,height:400 
	,title:"Assign attributes to group"
	,_controller_:net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup
	,_filterFields_: [["id","Id"],["name","Name"]]
	,_defaultFilterField_ : "name" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Right"})
	}
});	 
