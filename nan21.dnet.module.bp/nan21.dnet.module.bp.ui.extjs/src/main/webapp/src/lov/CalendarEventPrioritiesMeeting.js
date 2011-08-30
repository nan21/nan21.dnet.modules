Ext.ns("net.nan21.dnet.module.bp.calendar.lovs");
net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesMeeting = Ext.extend( dnet.base.AbstractCombo, {	
	 initComponent : function(){
		Ext.apply(
		    this, {
                 mode: "remote"
				,displayField:"name"
				,triggerAction :"query"
				,pageSize:30
				,autoSelect:true
				,listWidth:250 
				,tpl: '<tpl for="."><div class="x-combo-list-item"><div style="">{name}</div></div></tpl>'
				,minChars:0	
				,_dataProviderFields_: 	net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventPriorityMeetingLovDs		
				,_dataProviderName_:"CalendarEventPriorityMeetingLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI",bundle:"nan21.dnet.module.bp.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesMeeting.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesMeeting", net.nan21.dnet.module.bp.calendar.lovs.CalendarEventPrioritiesMeeting);
 
