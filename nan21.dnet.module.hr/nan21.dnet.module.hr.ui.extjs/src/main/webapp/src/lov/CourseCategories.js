
Ext.define("net.nan21.dnet.module.hr.training.lovs.CourseCategories", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.training.lovs.CourseCategories",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.training.frame.CourseType_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasCategory"},
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.CourseCategoryLovDs",
	_dataProviderName_:"CourseCategoryLovDs"	 		
	
}); 
 
