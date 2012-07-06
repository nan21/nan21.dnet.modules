
Ext.define("net.nan21.dnet.module.hr.time.lovs.AbsenceReasons", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.time.lovs.AbsenceReasons",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.time.frame.AbsenceBaseData_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasReason"},
	recordModel: "net.nan21.dnet.module.hr.time.ds.model.AbsenceReasonLovDs",
	_dataProviderName_:"AbsenceReasonLovDs"	 		
	
}); 
 
