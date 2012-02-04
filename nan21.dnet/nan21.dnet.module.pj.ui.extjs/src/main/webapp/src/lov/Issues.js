
Ext.define("net.nan21.dnet.module.pj.md.lovs.Issues", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.pj.md.lovs.Issues",
 
	displayField:"code",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{code}, {name}, {code}, {summary}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.pj.md.frame.Issues_UI",bundle:"nan21.dnet.module.pj.ui.extjs"},
	recordModel: "net.nan21.dnet.module.pj.md.ds.model.IssueLovDs",
	_dataProviderName_:"IssueLovDs"	 		
	
}); 
 
