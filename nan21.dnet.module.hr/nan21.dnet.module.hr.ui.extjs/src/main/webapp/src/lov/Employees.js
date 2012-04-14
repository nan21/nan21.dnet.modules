
Ext.define("net.nan21.dnet.module.hr.employee.lovs.Employees", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.employee.lovs.Employees",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.employee.frame.Employee_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeLovDs",
	_dataProviderName_:"EmployeeLovDs"	 		
	
}); 
 
