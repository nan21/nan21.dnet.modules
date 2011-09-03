Ext.ns("net.nan21.dnet.module.mm.md.asgn");
net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "AttributesOfAttrGroup", 
	recordFields : [{name:"id",type:"string"},{name:"name",type:"string"},{name:"description",type:"string"}]
});	 
 
net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"name", header:"name", dataIndex:"name", width:150 })
		.addTextColumn( {name:"description", header:"description", dataIndex:"description", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Left", net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$List);
Ext.reg("net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Right", net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$List); 

net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:700
	,height:400 
	,title:"Assign attributes to group"
	,_controller_:net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Ui", net.nan21.dnet.module.mm.md.asgn.AttributesOfAttrGroup$Ui);