Ext.ns("net.nan21.dnet.module.bp.calendar.lovs");
net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusMeetingLovDs		
				,_dataProviderName_:"CalendarEventStatusMeetingLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI",bundle:"nan21.dnet.module.bp.ui.extjs",tocElement: "canvasStatus"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting", net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusMeeting);
 
