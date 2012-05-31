
Ext.define("net.nan21.dnet.module.ad.system.lovs.SysJobCtx", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.ad.system.lovs.SysJobCtx",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.ad.system.frame.SysJobCtx_UI",bundle:"nan21.dnet.module.ad.ui.extjs"},
	recordModel: "net.nan21.dnet.module.ad.system.ds.model.SysJobCtxLovDs",
	_dataProviderName_:"SysJobCtxLovDs"	 		
	
}); 
 
