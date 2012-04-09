
Ext.define("net.nan21.dnet.module.hr.payroll.lovs.ElementsCode", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.payroll.lovs.ElementsCode",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Element_UI",bundle:"nan21.dnet.module.hr.ui.extjs"},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementLovDs",
	_dataProviderName_:"ElementLovDs"	 		
	
}); 
 
