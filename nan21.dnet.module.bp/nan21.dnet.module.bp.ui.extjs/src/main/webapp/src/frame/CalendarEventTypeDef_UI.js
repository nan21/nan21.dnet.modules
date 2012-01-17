Dnet.doImport(["", "nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusDs", "nan21.dnet.module.bp.ui.extjs/dc/CalendarEventStatus", "nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityDs", "nan21.dnet.module.bp.ui.extjs/dc/CalendarEventPriority"]);

Ext.define("net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI",
	
	 _name_ : "net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("status", new net.nan21.dnet.module.bp.calendar.dc.CalendarEventStatus({multiEdit:true}))
		.addDc("priority", new net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("status",{ name:"statusFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.CalendarEventStatus$Filter",height:120})	 
		.addDcView("status",{ name:"statusEditList", xtype:"net.nan21.dnet.module.bp.calendar.dc.CalendarEventStatus$EditList", frame:true})	 
		.addDcFilterFormView("priority",{ name:"priorityFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority$Filter",height:120})	 
		.addDcView("priority",{ name:"priorityEditList", xtype:"net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvasStatus", layout:"border", defaults:{split:true},title:"Event status",preventHeader:true})  	 
		.addPanel({name: "canvasPriority", layout:"border", defaults:{split:true},title:"Event priority",preventHeader:true})  	 
			
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addToc(["canvasStatus","canvasPriority"]);
		this._mainViewName_  = "_main_with_toc_";	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvasStatus","canvasPriority"]) 				 		
		.addChildrenTo("canvasStatus",["statusFilter","statusEditList"] ,["north","center"])	
		.addChildrenTo("canvasPriority",["priorityFilter","priorityEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvasStatus","statusTlb")	  	
	 	.addToolbarTo("canvasPriority","priorityTlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("statusTlb", {dc:"status"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Event status"}).end()
			.beginToolbar("priorityTlb", {dc:"priority"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addSeparator().addSeparator().addTitle({"text":"Event priority"}).end(); 	
	}

});  
