
Ext.define("net.nan21.dnet.module.hr.time.lovs.AbsenceCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.time.lovs.AbsenceCategories",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasCateg"},
	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceCategoryLovDs",
	_dataProviderName_:"AbsenceCategoryLovDs"	 		
	
}); 
 
