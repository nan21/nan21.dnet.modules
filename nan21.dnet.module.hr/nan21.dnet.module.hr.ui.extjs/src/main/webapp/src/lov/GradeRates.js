
Ext.define("net.nan21.dnet.module.hr.grade.lovs.GradeRates", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.grade.lovs.GradeRates",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.grade.frame.GradeRate_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.grade.ds.model.GradeRateLovDs",
	_dataProviderName_:"GradeRateLovDs"	 		
	
}); 
 
