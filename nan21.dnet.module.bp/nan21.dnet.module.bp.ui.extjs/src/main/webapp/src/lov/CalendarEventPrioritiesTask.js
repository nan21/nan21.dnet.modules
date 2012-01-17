
Ext.define("net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesTask", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesTask",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasPriority"},
	recordModel: "net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityTaskLovDs",
	_dataProviderName_:"CalendarEventPriorityTaskLovDs"	 		
	
}); 
 
