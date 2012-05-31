
Ext.define("net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.org.lovs.OrganizationHierarchyItems",
 
	displayField:"org",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{org}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.org.frame.Org_UI",bundle:"nan21.dnet.module.bd.ui.extjs",tocElement: "canvasHierarchy"},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.OrganizationHierarchyItemLovDs",
	_dataProviderName_:"OrganizationHierarchyItemLovDs"	 		
	
}); 
 
