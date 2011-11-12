
Ext.define("net.nan21.dnet.module.pj.base.lovs.IssueCategories", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.IssueCategories",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.IssueBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasCategory"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.IssueCategoryLovDs",
	_dataProviderName_:"IssueCategoryLovDs"	 		
	
}); 
 
