	
Ext.define("net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory", {
	extend: "dnet.core.asgn.AbstractAsgn",
	dsName: "ProductsOfCategory", 
	recordModel: "net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Model"
});	 
 
Ext.define("net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Left","widget.net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"Code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
	alias: "widget.net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Ui",
 	 width:700
	,height:400 
	,title:"Assign attributes to group"
	,_controller_:net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory
	,_filterFields_: [["id","Id"],["code","Code"],["name","Name"]]
	,_defaultFilterField_ : "code" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Right"})
	}
});	 
