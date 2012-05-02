	
Ext.define("net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$Model" , {
	extend: 'Ext.data.Model',
	fields:  [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});
Ext.define("net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct", {
	extend: "dnet.core.asgn.AbstractAsgn",
	dsName: "CategoriesOfProduct", 
	recordModel: "net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$Model"
});	 
 
Ext.define("net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$List", {
	extend: "dnet.core.asgn.AbstractAsgnGrid",
	alias:[ "widget.net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$Left","widget.net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$Right" ],
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"Code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});

Ext.define("net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$Ui", {
	extend: "dnet.core.asgn.AbstractAsgnUi",
		 
 	width:700,
	height:400,
	title:"Assign categories to product",

	_controller_:net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct,
	_filterFields_: [["id","Id"],["code","Code"],["name","Name"]],
	_defaultFilterField_ : "code", 

	_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.md.mm.prod.asgn.CategoriesOfProduct$Right"})
	}
});	 
