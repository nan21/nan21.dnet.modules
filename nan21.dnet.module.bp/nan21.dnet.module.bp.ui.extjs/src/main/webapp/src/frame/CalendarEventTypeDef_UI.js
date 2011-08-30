Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/CalendarEventStatusDs", "nan21.dnet.module.bp.ui.extjs/dc/CalendarEventStatus", "nan21.dnet.module.bp.ui.extjs/ds/CalendarEventPriorityDs", "nan21.dnet.module.bp.ui.extjs/dc/CalendarEventPriority"]);

Ext.ns("net.nan21.dnet.module.bp.calendar.frame");
net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI"
	,_defineDcs_: function() {	
		this._getBuilder_()
		.addDc("status", new net.nan21.dnet.module.bp.calendar.dc.CalendarEventStatus({multiEdit:true}))
		.addDc("priority", new net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority({multiEdit:true}))		;		
	}	 

	,_defineElements_: function() {					
			
		this._mainViewName_  = "_main_with_toc_";
		this._getBuilder_()
		.addPanel({name:"_main_with_toc_", layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		})
		.addPanel({ name:"_toc_",xtype: 'treepanel',collapsible: true, region:"west", title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
			,minWidth:150, maxWidth:500
			,root: new Ext.tree.AsyncTreeNode({expanded: true,
            children: [{ text:"Event status", leaf: true , name:"canvas1"},{ text:"Event priority", leaf: true , name:"canvas2"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		}); 
		this._getBuilder_()	
		.addDcFilterFormView("status",{ name:"statusFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.CalendarEventStatus$Filter"})	 
		.addDcView("status",{ name:"statusEditList", xtype:"net.nan21.dnet.module.bp.calendar.dc.CalendarEventStatus$EditList", frame:true})	 
		.addDcFilterFormView("priority",{ name:"priorityFilter", xtype:"net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority$Filter"})	 
		.addDcView("priority",{ name:"priorityEditList", xtype:"net.nan21.dnet.module.bp.calendar.dc.CalendarEventPriority$EditList", frame:true})	 
		.addPanel({name: "main",layout:"card", activeItem:0})  	 
		.addPanel({name: "canvas1", layout:"border", defaults:{split:true},title:"Event status",header:false})  	 
		.addPanel({name: "canvas2", layout:"border", defaults:{split:true},title:"Event priority",header:false})  	 
			 	
	}

	,_linkElements_: function() {
		this._getBuilder_()		
	 	.addChildrenTo("main", ["canvas1","canvas2"]) 				 		
		.addChildrenTo("canvas1",["statusFilter","statusEditList"] ,["north","center"])	
		.addChildrenTo("canvas2",["priorityFilter","priorityEditList"] ,["north","center"])	
				
		.addChildrenTo("_main_with_toc_",["main","_toc_"]).change("main",{region: "center"})
	 	.addToolbarTo("canvas1","statusTlb")	  	
	 	.addToolbarTo("canvas2","priorityTlb")	  	
	}

	,_defineToolbars_: function() {
		this._getBuilder_()
			.beginToolbar("statusTlb", {dc:"status"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end()
			.beginToolbar("priorityTlb", {dc:"priority"}).addQuery().addSave().addNew().addCopy().addDeleteSelected().addCancel().end(); 	
	}

});
Ext.reg("net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI", net.nan21.dnet.module.bp.calendar.frame.CalendarEventTypeDef_UI);   
