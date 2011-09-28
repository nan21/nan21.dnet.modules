
Ext.define("net.nan21.dnet.module.ad.report.lovs.ReportServers", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.report.lovs.ReportServers",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.report.frame.ReportServers_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.report.ds.model.ReportServerLovDs",
	_dataProviderName_:"ReportServerLovDs"	 		
	
}); 
 
