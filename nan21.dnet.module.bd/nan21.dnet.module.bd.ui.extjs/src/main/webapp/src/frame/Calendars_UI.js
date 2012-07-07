Dnet.doImport(["", "nan21.dnet.module.bd.ui.extjs/ds/CalendarDs", "nan21.dnet.module.bd.ui.extjs/dc/Calendar"]);

Ext.define("net.nan21.dnet.module.bd.org.frame.Calendars_UI", {  
	extend: "dnet.core.ui.AbstractUi",
	alias:"widget.net.nan21.dnet.module.bd.org.frame.Calendars_UI",
	
	 _name_ : "net.nan21.dnet.module.bd.org.frame.Calendars_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("calendar", new net.nan21.dnet.module.bd.org.dc.Calendar({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {							
		this._getBuilder_()	
		.addDcFilterFormView("calendar",{ name:"calendarFilter", xtype:"net.nan21.dnet.module.bd.org.dc.Calendar$Filter"})	 
		.addDcEditGridView("calendar",{ name:"calendarEditList", xtype:"net.nan21.dnet.module.bd.org.dc.Calendar$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},preventHeader:true})  	 
;	 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1"]) 				 		
		.addChildrenTo("canvas1",["calendarFilter","calendarEditList"] ,["north","center"])	
	 	.addToolbarTo("canvas1","tlbCalendarList")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("tlbCalendarList", {dc:"calendar"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().addReports().addSeparator().addSeparator().addTitle({"text":"Calendars"}).end(); 	
	}

});  
