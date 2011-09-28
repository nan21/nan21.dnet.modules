
Ext.define("net.nan21.dnet.module.ad.system.lovs.SysDataSource", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.system.lovs.SysDataSource",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.system.frame.SysDataSources_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDataSourceLovDs",
	_dataProviderName_:"SysDataSourceLovDs"	 		
	
}); 
 
