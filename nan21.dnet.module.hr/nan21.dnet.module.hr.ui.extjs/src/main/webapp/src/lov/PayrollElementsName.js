
Ext.define("net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsName", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.payroll.lovs.PayrollElementsName",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.PayrollElement_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollElementLovDs",
	_dataProviderName_:"PayrollElementLovDs"	 		
	
}); 
 
