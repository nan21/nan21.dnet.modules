
Ext.define("net.nan21.dnet.module.md.base.period.lovs.FiscalPeriods", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.base.period.lovs.FiscalPeriods",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.base.period.frame.FiscalPeriod_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.base.period.ds.model.FiscalPeriodLovDs",
	_dataProviderName_:"FiscalPeriodLovDs"	 		
	
}); 
 
