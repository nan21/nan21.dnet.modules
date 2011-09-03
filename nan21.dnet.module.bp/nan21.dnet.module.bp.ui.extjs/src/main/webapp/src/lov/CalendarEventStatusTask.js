Ext.ns("net.nan21.dnet.module.bp.calendar.lovs");
net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusTask = Ext.extend( dnet.base.AbstractCombo, {	
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
				,_dataProviderFields_: 	net.nan21.dnet.module.bp.calendar.ds.model.CalendarEventStatusTaskLovDs		
				,_dataProviderName_:"CalendarEventStatusTaskLovDs"				 
				,_editDialog_:{custom:false, name: "net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI",bundle:"nan21.dnet.module.bp.ui.extjs"}
			}
		); 		 
		this._createStore_(); 
        net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusTask.superclass.initComponent.call(this);
	}	 
}); 
Ext.reg("net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusTask", net.nan21.dnet.module.bp.calendar.lovs.CalendarEventStatusTask);
 