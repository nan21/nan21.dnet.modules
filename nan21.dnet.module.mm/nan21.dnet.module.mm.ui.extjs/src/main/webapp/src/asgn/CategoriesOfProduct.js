Ext.ns("net.nan21.dnet.module.mm.md.asgn");
net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "CategoriesOfProduct", 
	recordFields : [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});	 
 
net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"Code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Left", net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$List);
Ext.reg("net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Right", net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$List); 

net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,title:"Assign categories to product"
	,_controller_:net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct
	,_filterFields_: [["id","Id"],["code","Code"],["name","Name"]]
	,_defaultFilterField_ : "code" 
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Ui", net.nan21.dnet.module.mm.md.asgn.CategoriesOfProduct$Ui);