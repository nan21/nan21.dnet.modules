
Ext.define("net.nan21.dnet.module.ad.system.lovs.SysJob", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.system.lovs.SysJob",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.system.frame.SysJob_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobLovDs",
	_dataProviderName_:"SysJobLovDs"	 		
	
}); 
 
