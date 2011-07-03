Ext.ns("net.nan21.dnet.module.ad.org.asgn");
net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems = Ext.extend(dnet.base.AbstractAsgn, {
	dsName: "OrganizationHierarchyItems", 
	recordFields : [{name:"id",type:"string"},{name:"code",type:"string"},{name:"name",type:"string"}]
});	 
 
net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$List = Ext.extend( dnet.base.AbstractAsgnGrid, {
	_defineColumns_: function () {
		this._getBuilder_()		
		.addTextColumn( {name:"id", header:"id", dataIndex:"id", hidden:true, width:100})
		.addTextColumn( {name:"code", header:"code", dataIndex:"code", width:100 })
		.addTextColumn( {name:"name", header:"name", dataIndex:"name", width:150 })
	} 
});
Ext.reg("net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$Left", net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$List);
Ext.reg("net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$Right", net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$List); 

net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$Ui = Ext.extend(dnet.base.AbstractAsgnUi, {
 	 width:500
	,height:300 
	,title:"User roles"
	,_controller_:net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems
	 
	,_defineElements_: function () {
		this._getBuilder_()
			.addLeftGrid({ xtype:"net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$Left"})
			.addRightGrid({ xtype:"net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$Right"})
	}
});	 
Ext.reg("net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$Ui", net.nan21.dnet.module.ad.org.asgn.OrganizationHierarchyItems$Ui);