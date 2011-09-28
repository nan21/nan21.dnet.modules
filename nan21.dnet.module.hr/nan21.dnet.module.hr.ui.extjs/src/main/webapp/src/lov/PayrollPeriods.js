
Ext.define("net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.payroll.lovs.PayrollPeriods",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {startDate}, {endDate}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Payroll_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.PayrollPeriodLovDs",
	_dataProviderName_:"PayrollPeriodLovDs"	 		
	
}); 
 
