
Ext.define("net.nan21.dnet.module.hr.employee.lovs.EmployeeContactRelationships", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.employee.lovs.EmployeeContactRelationships",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.employee.frame.EmployeeTypeDefs_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasContactRel"},
	recordModel: "net.nan21.dnet.module.hr.employee.ds.model.EmployeeContactRelationshipLovDs",
	_dataProviderName_:"EmployeeContactRelationshipLovDs"	 		
	
}); 
 
