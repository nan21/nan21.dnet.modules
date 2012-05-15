
Ext.define("net.nan21.dnet.module.bd.org.lovs.Calendars", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bd.org.lovs.Calendars",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bd.org.frame.Calendars_UI",bundle:"nan21.dnet.module.bd.ui.extjs"},
	recordModel: "net.nan21.dnet.module.bd.org.ds.model.CalendarLovDs",
	_dataProviderName_:"CalendarLovDs"	 		
	
}); 
 
