Ext.ns("net.nan21.dnet.module.mm.md.asgn");
net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "ProductsOfCategory", 
	recordFields : [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});	 
 
net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"Id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"Code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"Name", dataIndex:"name", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Left", net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$List);
Ext.reg("net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Right", net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$List); 

net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
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
Ext.reg("net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Ui", net.nan21.dnet.module.mm.md.asgn.ProductsOfCategory$Ui);