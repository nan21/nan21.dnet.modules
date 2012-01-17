
Ext.define("net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting", {
	extend: "dnet.core.lov.AbstractCombo",
	alias: "widget.net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting",
 
	displayField:"name",
	listConfig: {		
		getInnerTpl: function() { 
			return '<span>{name}</span>';
		},
		width:250
	},		 
	_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasStatus"},
	recordModel: "net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusMeetingLovDs",
	_dataProviderName_:"CalendarEventStatusMeetingLovDs"	 		
	
}); 
 
