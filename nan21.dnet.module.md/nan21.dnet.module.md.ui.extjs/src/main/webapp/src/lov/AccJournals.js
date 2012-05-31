
Ext.define("net.nan21.dnet.module.md.acc.lovs.AccJournals", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.acc.lovs.AccJournals",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.acc.frame.AccJournal_UI",bundle:"nan21.dnet.module.md.ui.extjs"},
	recordModel: "net.nan21.dnet.module.md.acc.ds.model.AccJournalLovDs",
	_dataProviderName_:"AccJournalLovDs"	 		
	
}); 
 
