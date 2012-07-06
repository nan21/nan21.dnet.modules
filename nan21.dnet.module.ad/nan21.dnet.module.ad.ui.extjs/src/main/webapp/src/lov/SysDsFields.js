
Ext.define("net.nan21.dnet.module.ad.system.lovs.SysDsFields", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.system.lovs.SysDsFields",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.system.frame.SysDataSources_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysDsFieldLovDs",
	_dataProviderName_:"SysDsFieldLovDs"	 		
	
}); 
 
