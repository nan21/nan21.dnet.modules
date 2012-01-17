
Ext.define("net.nan21.dnet.module.hr.grade.lovs.Grades", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.grade.lovs.Grades",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.grade.frame.Grade_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.GradeLovDs",
	_dataProviderName_:"GradeLovDs"	 		
	
}); 
 
