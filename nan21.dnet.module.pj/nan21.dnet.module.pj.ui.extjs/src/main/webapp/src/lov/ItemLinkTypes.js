
Ext.define("net.nan21.dnet.module.pj.base.lovs.ItemLinkTypes", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.base.lovs.ItemLinkTypes",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.base.frame.ItemBaseData_UI",bundle:"nan21.dnet.module.pj.ui.extjs",tocElement: "canvasLinktype"},
	recordModel: "net.nan21.dnet.module.pj.base.ds.model.ItemLinkTypeLovDs",
	_dataProviderName_:"ItemLinkTypeLovDs"	 		
	
}); 
 
