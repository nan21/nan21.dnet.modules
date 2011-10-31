	
Ext.define("net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents", {
	extend: "dnet.base.AbstractAsgn",
	dsName: "ItemAffectedComponents", 
	recordModel: "net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Model"
});	 
 
Ext.define("net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$List", {
	extend: "dnet.base.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Left","widget.net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:100 })
	} 
});

Ext.define("net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Ui", {
	extend: "dnet.base.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Ui",
 	 width:650
	,height:400 
	,title:"Affected components"
	,_controller_:net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents
	,_filterFields_: [["id","Id"],["name","Name"]]
	,_defaultFilterField_ : "name" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.pj.md.asgn.ItemAffectedComponents$Right"})
	}
});	 
