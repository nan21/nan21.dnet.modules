Ext.ns("net.nan21.dnet.module.mm.md.asgn");
net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "AttrGroupsOfAttribute", 
	recordFields : [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});	 
 
net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"description", dataIndex:"description", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Left", net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$List);
Ext.reg("net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Right", net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$List); 

net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,title:"Assign groups to attribute"
	,_controller_:net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Ui", net.nan21.dnet.module.mm.md.asgn.AttrGroupsOfAttribute$Ui);