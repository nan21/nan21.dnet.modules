
Ext.define("net.nan21.dnet.module.md.activity.lovs.CalendarEventStatusTask", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.activity.lovs.CalendarEventStatusTask",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.activity.frame.CalendarEventTypeDef_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasStatus"},
	recordModel: "net.nan21.dnet.module.md.activity.ds.model.CalendarEventStatusTaskLovDs",
	_dataProviderName_:"CalendarEventStatusTaskLovDs"	 		
	
}); 
 
