
Ext.define("net.nan21.dnet.module.pj.md.lovs.Items", {
	extend: "dnet.base.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.md.lovs.Items",
 
	displayField:"id",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{summary}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.md.frame.Items_UI",bundle:"nan21.dnet.module.pj.ui.extjs"},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.ItemLovDs",
	_dataProviderName_:"ItemLovDs"	 		
	
}); 
 
