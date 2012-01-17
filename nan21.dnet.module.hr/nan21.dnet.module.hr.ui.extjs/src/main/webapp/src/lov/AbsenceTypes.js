
Ext.define("net.nan21.dnet.module.hr.time.lovs.AbsenceTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.time.lovs.AbsenceTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceTypeLovDs",
	_dataProviderName_:"AbsenceTypeLovDs"	 		
	
}); 
 
