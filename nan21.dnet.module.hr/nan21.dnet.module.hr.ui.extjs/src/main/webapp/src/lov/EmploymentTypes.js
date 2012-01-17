
Ext.define("net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.employee.lovs.EmploymentTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasAsgnType"},
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmploymentTypeLovDs",
	_dataProviderName_:"EmploymentTypeLovDs"	 		
	
}); 
 
