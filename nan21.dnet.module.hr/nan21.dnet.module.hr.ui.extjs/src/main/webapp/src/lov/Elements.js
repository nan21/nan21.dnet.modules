
Ext.define("net.nan21.dnet.module.hr.payroll.lovs.Elements", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.hr.payroll.lovs.Elements",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.hr.payroll.frame.Element_UI",bundle:"nan21.dnet.module.hr.ui.extjs",tocElement: "canvasElems"},
	recordModel: "net.nan21.dnet.module.hr.payroll.ds.model.ElementLovDs",
	_dataProviderName_:"ElementLovDs"	 		
	
}); 
 
