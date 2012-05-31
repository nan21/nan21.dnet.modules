
Ext.define("net.nan21.dnet.module.md.base.period.lovs.FiscalYears", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.period.lovs.FiscalYears",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.period.frame.FiscalYear_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalYearLovDs",
	_dataProviderName_:"FiscalYearLovDs"	 		
	
}); 
 
