
Ext.define("net.nan21.dnet.module.ad.report.lovs.Reports", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.report.lovs.Reports",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.report.frame.Reports_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.report.ds.model.ReportLovDs",
	_dataProviderName_:"ReportLovDs"	 		
	
}); 
 
