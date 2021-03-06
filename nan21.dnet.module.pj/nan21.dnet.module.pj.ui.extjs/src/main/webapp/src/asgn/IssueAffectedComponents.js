	
Ext.define("net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents", {
	extend: "dnet.core.asgn.AbstractAsgn",
	dsName: "IssueAffectedComponents", 
	recordModel: "net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Model"
});	 
 
Ext.define("net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Left","widget.net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:100 })
	} 
});

Ext.define("net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
		 
 	width:700,
	height:400,
	title:"Affected components",

	_controller_:net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents,
	_filterFields_: [["id","Id"],["name","Name"]],
	_defaultFilterField_ : "name", 

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.pj.md.asgn.IssueAffectedComponents$Right"})
	}
});	 
