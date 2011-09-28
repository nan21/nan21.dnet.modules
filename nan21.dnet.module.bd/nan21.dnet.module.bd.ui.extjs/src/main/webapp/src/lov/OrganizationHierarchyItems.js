
Ext.define("net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems",
 
	displayField:"organizationCode",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{organizationCode}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.org.frame.Org_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasHierarchy"},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDs",
	_dataProviderName_:"OrganizationHierarchyItemLovDs"	 		
	
}); 
 
