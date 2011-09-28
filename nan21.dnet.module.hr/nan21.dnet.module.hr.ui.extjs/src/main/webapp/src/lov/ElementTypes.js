
Ext.define("net.nan21.dnet.module.hr.payroll.lovs.ElementTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.payroll.lovs.ElementTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Element_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasType"},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementTypeLovDs",
	_dataProviderName_:"ElementTypeLovDs"	 		
	
}); 
 
