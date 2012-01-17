
Ext.define("net.nan21.dnet.module.hr.payroll.lovs.Payrolls", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.payroll.lovs.Payrolls",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Payroll_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollLovDs",
	_dataProviderName_:"PayrollLovDs"	 		
	
}); 
 
