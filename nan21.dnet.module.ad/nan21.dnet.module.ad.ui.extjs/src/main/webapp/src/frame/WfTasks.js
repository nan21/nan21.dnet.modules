 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/WfMyTaskDs", "nan21.dnet.module.ad.ui.extjs/dc/WfMyTask", "nan21.dnet.module.ad.ui.extjs/ds/WfAvailableTaskDs", "nan21.dnet.module.ad.ui.extjs/dc/WfAvailableTask", "nan21.dnet.module.ad.ui.extjs/ds/WfMyTaskHistoryDs", "nan21.dnet.module.ad.ui.extjs/dc/WfMyTaskHistory"]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.WfTasks = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WfTasks"
	
	,_defineDcs_: function () {	
		var  dcMytask = new net.nan21.dnet.module.ad.workflow.dc.WfMyTask({multiEdit:false}), dcAvailabletask = new net.nan21.dnet.module.ad.workflow.dc.WfAvailableTask({multiEdit:false}), dcMyhistory = new net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory({multiEdit:false});	 	
		
		this._dcs_.add("dcMytask", dcMytask);			
		
		this._dcs_.add("dcAvailabletask", dcAvailabletask);			
		
		this._dcs_.add("dcMyhistory", dcMyhistory);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			
		this._mainViewName_  = "_main_with_toc_";
		this._elems_.add("_main_with_toc_", { layout:"border", id:Ext.id(), defaults:{split:true}, header:false,
				listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }}
		});
		this._elems_.add("_toc_", { xtype: 'treepanel',collapsible: true, title: 'Navigation',width: 250,autoScroll: true,split: true,rootVisible: false,loader: new Ext.tree.TreeLoader()
			,minWidth:150, maxWidth:500
			,root: new Ext.tree.AsyncTreeNode({expanded: true,
            children: [{ text:"Current tasks", leaf: true , name:"canvas1"},{ text:"Available tasks", leaf: true , name:"canvas2"},{ text:"History", leaf: true , name:"canvas3"}]
        	})
        	,listeners: {scope:this, 
            	click: function(n) {
					this._showStackedViewElement_("main", n.attributes.name);			 
            	}            
        	}
		});	 
			this._elems_.add("btnCompleteTask", { xtype:"button", name:"btnCompleteTask", id:Ext.id(),iconCls:"icon-action-commit" 
					,text:"Complete task", tooltip:"Mark selected task as completed."
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };
							try{ this._getDc_("dcMytask").doService("completeTask", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("dcMytask").on("selectionChanged", function(evnt) {
		 	       if ((evnt.dc.selectedRecords.length == 1) ) { var btn = this._getElement_("btnCompleteTask"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnCompleteTask");if(btn) btn.disable();  }
			 }, this );					 	
			this._elems_.add("btnClaimTask", { xtype:"button", name:"btnClaimTask", id:Ext.id() 
					,text:"Claim task", tooltip:"Claim the selected task."
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };					var successFn = function(dc,response,serviceName,specs) {							 
this._getDc_("dcAvailabletask").doQuery();			 	

							 
							}; s.callbacks['successFn'] = successFn; s.callbacks['successScope'] = this;
							
							try{ this._getDc_("dcAvailabletask").doService("assignTask", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("dcAvailabletask").on("selectionChanged", function(evnt) {
		 	       if ((evnt.dc.selectedRecords.length == 1) ) { var btn = this._getElement_("btnClaimTask"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnClaimTask");if(btn) btn.disable();  }
			 }, this );					 	
		this._elems_.add("filterMytask", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfMyTask$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcMytask"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listMytask", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfMyTask$List", id:Ext.id(), _controller_:this._dcs_.get("dcMytask"),buttons:[ this._elems_.get("btnCompleteTask") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("filterAvailabletask", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfAvailableTask$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcAvailabletask"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listAvailabletask", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfAvailableTask$List", id:Ext.id(), _controller_:this._dcs_.get("dcAvailabletask"),buttons:[ this._elems_.get("btnClaimTask") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("filterMyhistory", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcMyhistory"),height:40 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listMyhistory", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfMyTaskHistory$List", id:Ext.id(), _controller_:this._dcs_.get("dcMyhistory") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Current tasks",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Available tasks",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas3", { layout:"border", id:Ext.id(), defaults:{split:true},title:"History",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
			
		this._elems_.get("main")["region"] = "center";
		this._elems_.get("_toc_")["region"] = "west";
		this._elems_.get("_main_with_toc_")["items"] = [ this._elems_.get("main") , this._elems_.get("_toc_")];
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") , this._elems_.get("canvas3") ]; 				 		
 
			this._elems_.get("filterMytask")["region"] = "north";			
			this._elems_.get("listMytask")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("filterMytask") , this._elems_.get("listMytask") ]; 				 		
 
			this._elems_.get("filterAvailabletask")["region"] = "north";			
			this._elems_.get("listAvailabletask")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("filterAvailabletask") , this._elems_.get("listAvailabletask") ]; 				 		
 
			this._elems_.get("filterMyhistory")["region"] = "north";			
			this._elems_.get("listMyhistory")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas3")["items"] = [ this._elems_.get("filterMyhistory") , this._elems_.get("listMyhistory") ]; 				 		
	 	this._linkToolbar_("tlbMytaskList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbAvailabletaskList", "canvas2");	 	  	
	 	this._linkToolbar_("tlbMyhistoryList", "canvas3");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbMytaskList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcMytask").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMytaskList-load"
		this._tlbitms_.add("tlbMytaskList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcMytask").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMytaskList-save_mr"
		this._tlbitms_.add("tlbMytaskList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcMytask").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMytaskList-new_mr"
		this._tlbitms_.add("tlbMytaskList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcMytask").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMytaskList-copy_mr"
		this._tlbitms_.add("tlbMytaskList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcMytask").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMytaskList-delete_mr"
		this._tlbitms_.add("tlbMytaskList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dcMytask").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMytaskList-rollback_mr"
		this._tlbitms_.add("tlbMytaskList___S00_", "-") ;
		this._tlbitms_.add("tlbMytaskList___S01_", "-") ;
		this._tlbitms_.add("tlbMytaskList___TITLE_",  {xtype:"tbtext", text:"WfMyTask"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbMytaskList__") != -1); } )
		this._tlbs_.add("tlbMytaskList" , t.getRange() );
	


			this._getDc_("dcMytask").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbMytaskList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcMytask").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbMytaskList__load")) this._tlbitms_.get("tlbMytaskList__load").enable();
                 if(this._tlbitms_.get("tlbMytaskList__new_sr"))this._tlbitms_.get("tlbMytaskList__new_sr").enable();
                 if(this._tlbitms_.get("tlbMytaskList__new_mr"))this._tlbitms_.get("tlbMytaskList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dcMytask").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbMytaskList__copy_mr")) this._tlbitms_.get("tlbMytaskList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbMytaskList__delete_mr")) this._tlbitms_.get("tlbMytaskList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbMytaskList__copy_mr")) this._tlbitms_.get("tlbMytaskList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbMytaskList__delete_mr")) this._tlbitms_.get("tlbMytaskList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dcMytask").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbMytaskList__load")) this._tlbitms_.get("tlbMytaskList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbMytaskList__save_mr")) this._tlbitms_.get("tlbMytaskList__save_mr").enable();
                    if(this._tlbitms_.get("tlbMytaskList__rollback_record_mr"))this._tlbitms_.get("tlbMytaskList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbMytaskList__rollback_mr"))this._tlbitms_.get("tlbMytaskList__rollback_mr").enable();
			  } , this );

			this._getDc_("dcMytask").on("cleanRecord" , function() {
		  		  if (this._getDc_("dcMytask").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbMytaskList__load")) this._tlbitms_.get("tlbMytaskList__load").disable();	                
                    if(this._tlbitms_.get("tlbMytaskList__save_mr"))this._tlbitms_.get("tlbMytaskList__save_mr").enable();
                    if(this._tlbitms_.get("tlbMytaskList__rollback_record_mr"))this._tlbitms_.get("tlbMytaskList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbMytaskList__rollback_mr"))this._tlbitms_.get("tlbMytaskList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbMytaskList__load")) this._tlbitms_.get("tlbMytaskList__load").enable();	
                  	if(this._tlbitms_.get("tlbMytaskList__back_mr"))this._tlbitms_.get("tlbMytaskList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbMytaskList__save_mr"))this._tlbitms_.get("tlbMytaskList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbMytaskList__rollback_record_mr"))this._tlbitms_.get("tlbMytaskList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbMytaskList__rollback_mr"))this._tlbitms_.get("tlbMytaskList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbAvailabletaskList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcAvailabletask").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAvailabletaskList-load"
		this._tlbitms_.add("tlbAvailabletaskList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcAvailabletask").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbAvailabletaskList-save_mr"
		this._tlbitms_.add("tlbAvailabletaskList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcAvailabletask").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAvailabletaskList-new_mr"
		this._tlbitms_.add("tlbAvailabletaskList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcAvailabletask").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAvailabletaskList-copy_mr"
		this._tlbitms_.add("tlbAvailabletaskList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcAvailabletask").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAvailabletaskList-delete_mr"
		this._tlbitms_.add("tlbAvailabletaskList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dcAvailabletask").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbAvailabletaskList-rollback_mr"
		this._tlbitms_.add("tlbAvailabletaskList___S00_", "-") ;
		this._tlbitms_.add("tlbAvailabletaskList___S01_", "-") ;
		this._tlbitms_.add("tlbAvailabletaskList___TITLE_",  {xtype:"tbtext", text:"WfAvailableTask"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbAvailabletaskList__") != -1); } )
		this._tlbs_.add("tlbAvailabletaskList" , t.getRange() );
	


			this._getDc_("dcAvailabletask").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbAvailabletaskList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcAvailabletask").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbAvailabletaskList__load")) this._tlbitms_.get("tlbAvailabletaskList__load").enable();
                 if(this._tlbitms_.get("tlbAvailabletaskList__new_sr"))this._tlbitms_.get("tlbAvailabletaskList__new_sr").enable();
                 if(this._tlbitms_.get("tlbAvailabletaskList__new_mr"))this._tlbitms_.get("tlbAvailabletaskList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dcAvailabletask").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbAvailabletaskList__copy_mr")) this._tlbitms_.get("tlbAvailabletaskList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbAvailabletaskList__delete_mr")) this._tlbitms_.get("tlbAvailabletaskList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbAvailabletaskList__copy_mr")) this._tlbitms_.get("tlbAvailabletaskList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbAvailabletaskList__delete_mr")) this._tlbitms_.get("tlbAvailabletaskList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dcAvailabletask").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbAvailabletaskList__load")) this._tlbitms_.get("tlbAvailabletaskList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbAvailabletaskList__save_mr")) this._tlbitms_.get("tlbAvailabletaskList__save_mr").enable();
                    if(this._tlbitms_.get("tlbAvailabletaskList__rollback_record_mr"))this._tlbitms_.get("tlbAvailabletaskList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbAvailabletaskList__rollback_mr"))this._tlbitms_.get("tlbAvailabletaskList__rollback_mr").enable();
			  } , this );

			this._getDc_("dcAvailabletask").on("cleanRecord" , function() {
		  		  if (this._getDc_("dcAvailabletask").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbAvailabletaskList__load")) this._tlbitms_.get("tlbAvailabletaskList__load").disable();	                
                    if(this._tlbitms_.get("tlbAvailabletaskList__save_mr"))this._tlbitms_.get("tlbAvailabletaskList__save_mr").enable();
                    if(this._tlbitms_.get("tlbAvailabletaskList__rollback_record_mr"))this._tlbitms_.get("tlbAvailabletaskList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbAvailabletaskList__rollback_mr"))this._tlbitms_.get("tlbAvailabletaskList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbAvailabletaskList__load")) this._tlbitms_.get("tlbAvailabletaskList__load").enable();	
                  	if(this._tlbitms_.get("tlbAvailabletaskList__back_mr"))this._tlbitms_.get("tlbAvailabletaskList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbAvailabletaskList__save_mr"))this._tlbitms_.get("tlbAvailabletaskList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbAvailabletaskList__rollback_record_mr"))this._tlbitms_.get("tlbAvailabletaskList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbAvailabletaskList__rollback_mr"))this._tlbitms_.get("tlbAvailabletaskList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbMyhistoryList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcMyhistory").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMyhistoryList-load"
		this._tlbitms_.add("tlbMyhistoryList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcMyhistory").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMyhistoryList-save_mr"
		this._tlbitms_.add("tlbMyhistoryList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcMyhistory").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMyhistoryList-new_mr"
		this._tlbitms_.add("tlbMyhistoryList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcMyhistory").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMyhistoryList-copy_mr"
		this._tlbitms_.add("tlbMyhistoryList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcMyhistory").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMyhistoryList-delete_mr"
		this._tlbitms_.add("tlbMyhistoryList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dcMyhistory").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMyhistoryList-rollback_mr"
		this._tlbitms_.add("tlbMyhistoryList___S00_", "-") ;
		this._tlbitms_.add("tlbMyhistoryList___S01_", "-") ;
		this._tlbitms_.add("tlbMyhistoryList___TITLE_",  {xtype:"tbtext", text:"WfMyTaskHistory"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbMyhistoryList__") != -1); } )
		this._tlbs_.add("tlbMyhistoryList" , t.getRange() );
	


			this._getDc_("dcMyhistory").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbMyhistoryList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcMyhistory").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbMyhistoryList__load")) this._tlbitms_.get("tlbMyhistoryList__load").enable();
                 if(this._tlbitms_.get("tlbMyhistoryList__new_sr"))this._tlbitms_.get("tlbMyhistoryList__new_sr").enable();
                 if(this._tlbitms_.get("tlbMyhistoryList__new_mr"))this._tlbitms_.get("tlbMyhistoryList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dcMyhistory").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbMyhistoryList__copy_mr")) this._tlbitms_.get("tlbMyhistoryList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbMyhistoryList__delete_mr")) this._tlbitms_.get("tlbMyhistoryList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbMyhistoryList__copy_mr")) this._tlbitms_.get("tlbMyhistoryList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbMyhistoryList__delete_mr")) this._tlbitms_.get("tlbMyhistoryList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dcMyhistory").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbMyhistoryList__load")) this._tlbitms_.get("tlbMyhistoryList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbMyhistoryList__save_mr")) this._tlbitms_.get("tlbMyhistoryList__save_mr").enable();
                    if(this._tlbitms_.get("tlbMyhistoryList__rollback_record_mr"))this._tlbitms_.get("tlbMyhistoryList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbMyhistoryList__rollback_mr"))this._tlbitms_.get("tlbMyhistoryList__rollback_mr").enable();
			  } , this );

			this._getDc_("dcMyhistory").on("cleanRecord" , function() {
		  		  if (this._getDc_("dcMyhistory").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbMyhistoryList__load")) this._tlbitms_.get("tlbMyhistoryList__load").disable();	                
                    if(this._tlbitms_.get("tlbMyhistoryList__save_mr"))this._tlbitms_.get("tlbMyhistoryList__save_mr").enable();
                    if(this._tlbitms_.get("tlbMyhistoryList__rollback_record_mr"))this._tlbitms_.get("tlbMyhistoryList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbMyhistoryList__rollback_mr"))this._tlbitms_.get("tlbMyhistoryList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbMyhistoryList__load")) this._tlbitms_.get("tlbMyhistoryList__load").enable();	
                  	if(this._tlbitms_.get("tlbMyhistoryList__back_mr"))this._tlbitms_.get("tlbMyhistoryList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbMyhistoryList__save_mr"))this._tlbitms_.get("tlbMyhistoryList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbMyhistoryList__rollback_record_mr"))this._tlbitms_.get("tlbMyhistoryList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbMyhistoryList__rollback_mr"))this._tlbitms_.get("tlbMyhistoryList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("dcMytask").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcAvailabletask").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcMyhistory").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.WfTasks", net.nan21.dnet.module.ad.workflow.frame.WfTasks);   
