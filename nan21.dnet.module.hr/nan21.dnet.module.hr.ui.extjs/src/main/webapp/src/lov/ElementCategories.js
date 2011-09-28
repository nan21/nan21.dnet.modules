
Ext.define("net.nan21.dnet.module.hr.payroll.lovs.ElementCategories", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.payroll.lovs.ElementCategories",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Element_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasCateg"},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementCategoryLovDs",
	_dataProviderName_:"ElementCategoryLovDs"	 		
	
}); 
 
