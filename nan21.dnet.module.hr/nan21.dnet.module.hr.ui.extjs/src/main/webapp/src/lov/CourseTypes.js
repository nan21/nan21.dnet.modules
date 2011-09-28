
Ext.define("net.nan21.dnet.module.hr.training.lovs.CourseTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.training.lovs.CourseTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.training.frame.CourseType_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.hr.training.ds.model.CourseTypeLovDs",
	_dataProviderName_:"CourseTypeLovDs"	 		
	
}); 
 
