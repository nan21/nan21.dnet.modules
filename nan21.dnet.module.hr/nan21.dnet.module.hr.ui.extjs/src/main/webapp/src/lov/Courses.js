
Ext.define("net.nan21.dnet.module.hr.training.lovs.Courses", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.training.lovs.Courses",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.training.frame.Course_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.CourseLovDs",
	_dataProviderName_:"CourseLovDs"	 		
	
}); 
 
