
Ext.define("net.nan21.dnet.module.bd.tx.lovs.FiscalPeriods", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.tx.lovs.FiscalPeriods",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.tx.frame.FiscalPeriod_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.tx.ds.model.FiscalPeriodLovDs",
	_dataProviderName_:"FiscalPeriodLovDs"	 		
	
}); 
 
