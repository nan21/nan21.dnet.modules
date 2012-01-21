	
Ext.define("net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions", {
	extend: "dnet.core.asgn.AbstractAsgn",
	dsName: "IssueAffectedVersions", 
	recordModel: "net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Model"
});	 
 
Ext.define("net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Left","widget.net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:100 })
	} 
});

Ext.define("net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Ui",
 	 width:700
	,height:400 
	,title:"Affected versions"
	,_controller_:net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions
	,_filterFields_: [["id","Id"],["name","Name"]]
	,_defaultFilterField_ : "name" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.pj.md.asgn.IssueAffectedVersions$Right"})
	}
});	 
