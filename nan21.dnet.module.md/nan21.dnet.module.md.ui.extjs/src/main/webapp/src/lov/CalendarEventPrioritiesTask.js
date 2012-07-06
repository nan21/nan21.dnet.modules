
Ext.define("net.nan21.dnet.module.md.activity.lovs.CalendarEventPrioritiesTask", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.md.activity.lovs.CalendarEventPrioritiesTask",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}, {description}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.md.activity.frame.CalendarEventTypeDef_UI",bundle:"nan21.dnet.module.md.ui.extjs",tocElement: "canvasPriority"},
	recordModel: "net.nan21.dnet.module.md.activity.ds.model.CalendarEventPriorityTaskLovDs",
	_dataProviderName_:"CalendarEventPriorityTaskLovDs"	 		
	
}); 
 
