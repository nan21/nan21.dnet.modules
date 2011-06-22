 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/WfDefProcessDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefProcess", "nan21.dnet.module.ad.ui.extjs/ds/WfDefNodeDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefNode", "nan21.dnet.module.ad.ui.extjs/ds/WfDefTransitionDs", "nan21.dnet.module.ad.ui.extjs/dc/WfDefTransition","nan21.dnet.module.ad.ui.extjs/ds/WfDefNodeTypeLovDs","nan21.dnet.module.ad.ui.extjs/lov/WfDefNodeTypes"]);

Ext.ns("net.nan21.dnet.module.ad.workflow.frame");
net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI"
	
	,_defineDcs_: function () {	
		var  dcProcess = new net.nan21.dnet.module.ad.workflow.dc.WfDefProcess({multiEdit:false}), dcNode = new net.nan21.dnet.module.ad.workflow.dc.WfDefNode({multiEdit:true}), dcTransition = new net.nan21.dnet.module.ad.workflow.dc.WfDefTransition({multiEdit:true});	 	
		
		this._dcs_.add("dcProcess", dcProcess);			
		dcNode.setDcContext(new dnet.base.DcContext({childDc:dcNode, parentDc:dcProcess, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"processId", parentField:"id"} ]}}));dcProcess.addChild(dcNode);
		this._dcs_.add("dcNode", dcNode);			
		dcTransition.setDcContext(new dnet.base.DcContext({childDc:dcTransition, parentDc:dcProcess, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"processId", parentField:"id"} ]}}));dcProcess.addChild(dcTransition);
		this._dcs_.add("dcTransition", dcTransition);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			this._elems_.add("btnDeploy", { xtype:"button", name:"btnDeploy", id:Ext.id(),iconCls:"icon-action-run" 
					,text:"Deploy", tooltip:"Deploy process"
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };
							try{ this._getDc_("dcProcess").doService("deployProcess", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("dcProcess").on("recordChanged", function(evnt) {
		 	       if ((evnt.status=='update') ) { var btn = this._getElement_("btnDeploy"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnDeploy");if(btn) btn.disable();  }
			 }, this );					 	
		this._elems_.add("filterProcess", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcProcess") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("listProcess", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$List", id:Ext.id(), _controller_:this._dcs_.get("dcProcess") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("formProcess", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefProcess$Edit", id:Ext.id(), _controller_:this._dcs_.get("dcProcess"),height:100,buttons:[ this._elems_.get("btnDeploy") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("dcProcess").isRecordValid = this._dcs_.get("dcProcess").isRecordValid.createInterceptor(function() { return this._getElement_("formProcess")._isValid_(); }, this);		 
		  
		this._elems_.add("elistNode", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefNode$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("dcNode") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("filterTransition", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$Filter", id:Ext.id(), _controller_:this._dcs_.get("dcTransition") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("elistTransition", { xtype:"net.nan21.dnet.module.ad.workflow.dc.WfDefTransition$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("dcTransition"),width:300 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("panelDetails", { layout:"border", id:Ext.id(), defaults:{split:true},listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);      } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("filterProcess")["region"] = "north";			
			this._elems_.get("listProcess")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("filterProcess") , this._elems_.get("listProcess") ]; 				 		
 
			this._elems_.get("formProcess")["region"] = "north";			
			this._elems_.get("panelDetails")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("formProcess") , this._elems_.get("panelDetails") ]; 				 		
 
			this._elems_.get("elistNode")["region"] = "center";			
			this._elems_.get("elistTransition")["region"] = "east";			
		   
	
	 	this._elems_.get("panelDetails")["items"] = [ this._elems_.get("elistNode") , this._elems_.get("elistTransition") ]; 				 		
	 	this._linkToolbar_("tlbProcessList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbProcessEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbNodeCtxEditList", "elistNode");	 	  	
	 	this._linkToolbar_("tlbTransitionEditList", "elistTransition");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbProcessList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcProcess").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProcessList-load"
		this._tlbitms_.add("tlbProcessList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcProcess")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbProcessList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProcessList-edit_sr"
		this._tlbitms_.add("tlbProcessList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcProcess").doNew(); this._invokeTlbItem_("tlbProcessList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProcessList-new_sr"
		this._tlbitms_.add("tlbProcessList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcProcess").doCopy(); this._invokeTlbItem_("tlbProcessList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProcessList-copy_sr"
		this._tlbitms_.add("tlbProcessList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcProcess").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProcessList-delete_selected_sr"
		this._tlbitms_.add("tlbProcessList___S00_", "-") ;
		this._tlbitms_.add("tlbProcessList___S01_", "-") ;
		this._tlbitms_.add("tlbProcessList___TITLE_",  {xtype:"tbtext", text:"WfDefProcess"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbProcessList__") != -1); } )
		this._tlbs_.add("tlbProcessList" , t.getRange() );

		this._getDc_("dcProcess").on("onEdit", function() {this._invokeTlbItem_("tlbProcessList__edit_sr");} , this);

	


			this._getDc_("dcProcess").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbProcessList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcProcess").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbProcessList__load")) this._tlbitms_.get("tlbProcessList__load").enable();
                 if(this._tlbitms_.get("tlbProcessList__new_sr"))this._tlbitms_.get("tlbProcessList__new_sr").enable();
                 if(this._tlbitms_.get("tlbProcessList__new_mr"))this._tlbitms_.get("tlbProcessList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("dcProcess").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbProcessList__edit_sr")) this._tlbitms_.get("tlbProcessList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbProcessList__copy_sr")) this._tlbitms_.get("tlbProcessList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbProcessList__delete_selected_sr")) this._tlbitms_.get("tlbProcessList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbProcessList__edit_sr")) this._tlbitms_.get("tlbProcessList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbProcessList__copy_sr")) this._tlbitms_.get("tlbProcessList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbProcessList__delete_selected_sr")) this._tlbitms_.get("tlbProcessList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbProcessEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("dcProcess")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbProcessEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProcessEdit-back_sr"
		this._tlbitms_.add("tlbProcessEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcProcess").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProcessEdit-save"
		this._tlbitms_.add("tlbProcessEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcProcess").doNew(); this._invokeTlbItem_("tlbProcessEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProcessEdit-new_sr"
		this._tlbitms_.add("tlbProcessEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcProcess").doCopy(); this._invokeTlbItem_("tlbProcessEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProcessEdit-copy_sr"
		this._tlbitms_.add("tlbProcessEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("dcProcess").getCurrentRecord().phantom) {this._getDc_("dcProcess").discardChanges();this._invokeTlbItem_("tlbProcessEdit__back_sr");} else  {this._getDc_("dcProcess").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProcessEdit-rollback_sr"
		this._tlbitms_.add("tlbProcessEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("dcProcess").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbProcessEdit-prev_rec_sr"
		this._tlbitms_.add("tlbProcessEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("dcProcess").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbProcessEdit-next_rec_sr"
		this._tlbitms_.add("tlbProcessEdit___S00_", "-") ;
		this._tlbitms_.add("tlbProcessEdit___S01_", "-") ;
		this._tlbitms_.add("tlbProcessEdit___TITLE_",  {xtype:"tbtext", text:"WfDefProcess"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbProcessEdit__") != -1); } )
		this._tlbs_.add("tlbProcessEdit" , t.getRange() );
	


			this._getDc_("dcProcess").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbProcessEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcProcess").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbProcessEdit__load")) this._tlbitms_.get("tlbProcessEdit__load").enable();
                 if(this._tlbitms_.get("tlbProcessEdit__new_sr"))this._tlbitms_.get("tlbProcessEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbProcessEdit__new_mr"))this._tlbitms_.get("tlbProcessEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("dcProcess").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbProcessEdit__back_sr")) this._tlbitms_.get("tlbProcessEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbProcessEdit__save")) this._tlbitms_.get("tlbProcessEdit__save").enable();
                    if(this._tlbitms_.get("tlbProcessEdit__new_sr")) this._tlbitms_.get("tlbProcessEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbProcessEdit__copy_sr")) this._tlbitms_.get("tlbProcessEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbProcessEdit__rollback_record_sr")) this._tlbitms_.get("tlbProcessEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbProcessEdit__rollback_sr")) this._tlbitms_.get("tlbProcessEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbProcessEdit__prev_rec_sr")) this._tlbitms_.get("tlbProcessEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbProcessEdit__next_rec_sr")) this._tlbitms_.get("tlbProcessEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("dcProcess").on("cleanRecord" , function() {
		  		  if (this._getDc_("dcProcess").isDirty() ) {
                    if(this._tlbitms_.get("tlbProcessEdit__back_sr")) this._tlbitms_.get("tlbProcessEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbProcessEdit__save")) this._tlbitms_.get("tlbProcessEdit__save").enable();
                    if(this._tlbitms_.get("tlbProcessEdit__new_sr")) this._tlbitms_.get("tlbProcessEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbProcessEdit__copy_sr")) this._tlbitms_.get("tlbProcessEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbProcessEdit__rollback_record_sr")) this._tlbitms_.get("tlbProcessEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbProcessEdit__rollback_sr")) this._tlbitms_.get("tlbProcessEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbProcessEdit__prev_rec_sr")) this._tlbitms_.get("tlbProcessEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbProcessEdit__next_rec_sr")) this._tlbitms_.get("tlbProcessEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbProcessEdit__back_sr")) this._tlbitms_.get("tlbProcessEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbProcessEdit__save")) this._tlbitms_.get("tlbProcessEdit__save").disable();
                  	if(this._tlbitms_.get("tlbProcessEdit__new_sr")) this._tlbitms_.get("tlbProcessEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbProcessEdit__copy_sr")) this._tlbitms_.get("tlbProcessEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbProcessEdit__rollback_record_sr")) this._tlbitms_.get("tlbProcessEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbProcessEdit__rollback_sr")) this._tlbitms_.get("tlbProcessEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbProcessEdit__prev_rec_sr")) this._tlbitms_.get("tlbProcessEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbProcessEdit__next_rec_sr")) this._tlbitms_.get("tlbProcessEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("dcProcess").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbProcessEdit__copy_sr")) this._tlbitms_.get("tlbProcessEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbNodeCtxEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcNode").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeCtxEditList-load"
		this._tlbitms_.add("tlbNodeCtxEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcNode").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbNodeCtxEditList-save_mr"
		this._tlbitms_.add("tlbNodeCtxEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcNode").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeCtxEditList-new_mr"
		this._tlbitms_.add("tlbNodeCtxEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcNode").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeCtxEditList-copy_mr"
		this._tlbitms_.add("tlbNodeCtxEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcNode").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeCtxEditList-delete_mr"
		this._tlbitms_.add("tlbNodeCtxEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dcNode").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbNodeCtxEditList-rollback_mr"
		this._tlbitms_.add("tlbNodeCtxEditList___S00_", "-") ;
		this._tlbitms_.add("tlbNodeCtxEditList___S01_", "-") ;
		this._tlbitms_.add("tlbNodeCtxEditList___TITLE_",  {xtype:"tbtext", text:"WfDefNode"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbNodeCtxEditList__") != -1); } )
		this._tlbs_.add("tlbNodeCtxEditList" , t.getRange() );
	


			this._getDc_("dcNode").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbNodeCtxEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcNode").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbNodeCtxEditList__load")) this._tlbitms_.get("tlbNodeCtxEditList__load").enable();
                 if(this._tlbitms_.get("tlbNodeCtxEditList__new_sr"))this._tlbitms_.get("tlbNodeCtxEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbNodeCtxEditList__new_mr"))this._tlbitms_.get("tlbNodeCtxEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dcNode").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbNodeCtxEditList__copy_mr")) this._tlbitms_.get("tlbNodeCtxEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbNodeCtxEditList__delete_mr")) this._tlbitms_.get("tlbNodeCtxEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbNodeCtxEditList__copy_mr")) this._tlbitms_.get("tlbNodeCtxEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbNodeCtxEditList__delete_mr")) this._tlbitms_.get("tlbNodeCtxEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dcNode").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbNodeCtxEditList__load")) this._tlbitms_.get("tlbNodeCtxEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbNodeCtxEditList__save_mr")) this._tlbitms_.get("tlbNodeCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbNodeCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbNodeCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbNodeCtxEditList__rollback_mr"))this._tlbitms_.get("tlbNodeCtxEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("dcNode").on("cleanRecord" , function() {
		  		  if (this._getDc_("dcNode").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbNodeCtxEditList__load")) this._tlbitms_.get("tlbNodeCtxEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbNodeCtxEditList__save_mr"))this._tlbitms_.get("tlbNodeCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbNodeCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbNodeCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbNodeCtxEditList__rollback_mr"))this._tlbitms_.get("tlbNodeCtxEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbNodeCtxEditList__load")) this._tlbitms_.get("tlbNodeCtxEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbNodeCtxEditList__back_mr"))this._tlbitms_.get("tlbNodeCtxEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbNodeCtxEditList__save_mr"))this._tlbitms_.get("tlbNodeCtxEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbNodeCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbNodeCtxEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbNodeCtxEditList__rollback_mr"))this._tlbitms_.get("tlbNodeCtxEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbTransitionEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcTransition").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTransitionEditList-load"
		this._tlbitms_.add("tlbTransitionEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcTransition").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbTransitionEditList-save_mr"
		this._tlbitms_.add("tlbTransitionEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("dcTransition").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTransitionEditList-new_mr"
		this._tlbitms_.add("tlbTransitionEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcTransition").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTransitionEditList-copy_mr"
		this._tlbitms_.add("tlbTransitionEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("dcTransition").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTransitionEditList-delete_mr"
		this._tlbitms_.add("tlbTransitionEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("dcTransition").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbTransitionEditList-rollback_mr"
		this._tlbitms_.add("tlbTransitionEditList___S00_", "-") ;
		this._tlbitms_.add("tlbTransitionEditList___S01_", "-") ;
		this._tlbitms_.add("tlbTransitionEditList___TITLE_",  {xtype:"tbtext", text:"WfDefTransition"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbTransitionEditList__") != -1); } )
		this._tlbs_.add("tlbTransitionEditList" , t.getRange() );
	


			this._getDc_("dcTransition").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbTransitionEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("dcTransition").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbTransitionEditList__load")) this._tlbitms_.get("tlbTransitionEditList__load").enable();
                 if(this._tlbitms_.get("tlbTransitionEditList__new_sr"))this._tlbitms_.get("tlbTransitionEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbTransitionEditList__new_mr"))this._tlbitms_.get("tlbTransitionEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("dcTransition").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbTransitionEditList__copy_mr")) this._tlbitms_.get("tlbTransitionEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbTransitionEditList__delete_mr")) this._tlbitms_.get("tlbTransitionEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbTransitionEditList__copy_mr")) this._tlbitms_.get("tlbTransitionEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbTransitionEditList__delete_mr")) this._tlbitms_.get("tlbTransitionEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("dcTransition").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbTransitionEditList__load")) this._tlbitms_.get("tlbTransitionEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbTransitionEditList__save_mr")) this._tlbitms_.get("tlbTransitionEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbTransitionEditList__rollback_record_mr"))this._tlbitms_.get("tlbTransitionEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbTransitionEditList__rollback_mr"))this._tlbitms_.get("tlbTransitionEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("dcTransition").on("cleanRecord" , function() {
		  		  if (this._getDc_("dcTransition").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbTransitionEditList__load")) this._tlbitms_.get("tlbTransitionEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbTransitionEditList__save_mr"))this._tlbitms_.get("tlbTransitionEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbTransitionEditList__rollback_record_mr"))this._tlbitms_.get("tlbTransitionEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbTransitionEditList__rollback_mr"))this._tlbitms_.get("tlbTransitionEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbTransitionEditList__load")) this._tlbitms_.get("tlbTransitionEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbTransitionEditList__back_mr"))this._tlbitms_.get("tlbTransitionEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbTransitionEditList__save_mr"))this._tlbitms_.get("tlbTransitionEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbTransitionEditList__rollback_record_mr"))this._tlbitms_.get("tlbTransitionEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbTransitionEditList__rollback_mr"))this._tlbitms_.get("tlbTransitionEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("dcProcess").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("formProcess").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcNode").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("dcTransition").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI", net.nan21.dnet.module.ad.workflow.frame.WorkflowDef_UI);   
