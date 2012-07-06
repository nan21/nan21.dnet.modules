
Ext.define("net.nan21.dnet.module.md.acc.lovs.AccItems", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.acc.lovs.AccItems",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.acc.frame.AccItem_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccItemLovDs",
	_dataProviderName_:"AccItemLovDs"	 		
	
}); 
 
