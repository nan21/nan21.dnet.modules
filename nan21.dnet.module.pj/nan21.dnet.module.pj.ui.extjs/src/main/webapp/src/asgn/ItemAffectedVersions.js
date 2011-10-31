	
Ext.define("net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions", {
	extend: "dnet.base.AbstractAsgn",
	dsName: "ItemAffectedVersions", 
	recordModel: "net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Model"
});	 
 
Ext.define("net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$List", {
	extend: "dnet.base.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Left","widget.net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:100 })
	} 
});

Ext.define("net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Ui", {
	extend: "dnet.base.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Ui",
 	 width:650
	,height:400 
	,title:"Affected versions"
	,_controller_:net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions
	,_filterFields_: [["id","Id"],["name","Name"]]
	,_defaultFilterField_ : "name" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.pj.md.asgn.ItemAffectedVersions$Right"})
	}
});	 
