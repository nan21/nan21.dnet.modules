 
Dnet.import(["", "nan21.dnet.module.ad.ui.extjs/ds/ImportJobDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportJob", "nan21.dnet.module.ad.ui.extjs/ds/ImportJobItemDs", "nan21.dnet.module.ad.ui.extjs/dc/ImportJobItem","nan21.dnet.module.ad.ui.extjs/ds/ImportMapLovDs","nan21.dnet.module.ad.ui.extjs/lov/ImportMap"]);

Ext.ns("net.nan21.dnet.module.ad.impex.frame");
net.nan21.dnet.module.ad.impex.frame.ImportJob_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.ad.impex.frame.ImportJob_UI"
	
	,_defineDcs_: function () {	
		var  job = new net.nan21.dnet.module.ad.impex.dc.ImportJob({multiEdit:false}), item = new net.nan21.dnet.module.ad.impex.dc.ImportJobItem({multiEdit:true});	 	
		
		this._dcs_.add("job", job);			
		item.setDcContext(new dnet.base.DcContext({childDc:item, parentDc:job, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"jobId", parentField:"id"} ]}}));job.addChild(item);
		this._dcs_.add("item", item);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
			this._elems_.add("btnRunImport", { xtype:"button", name:"btnRunImport", id:Ext.id(),iconCls:"icon-action-import" 
					,text:"Import All", tooltip:"Import all sets included in this job."
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };
							try{ this._getDc_("job").doService("runImport", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("job").on("recordChanged", function(evnt) {
		 	       if ((evnt.status=='update') ) { var btn = this._getElement_("btnRunImport"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnRunImport");if(btn) btn.disable();  }
			 }, this );					 	
			this._elems_.add("btnRunImportItem", { xtype:"button", name:"btnRunImportItem", id:Ext.id(),iconCls:"icon-action-import" 
					,text:"Import selected", tooltip:"Import the selected set (one at a time)."
					,disabled:true
					,handler: function() {
					var s={modal:true, callbacks:{} };
							try{ this._getDc_("item").doService("runImport", s); }catch(e){dnet.base.DcExceptions.showMessage(e);}

 
}					 	
 ,scope:this });	
			this._getDc_("item").on("selectionChanged", function(evnt) {
		 	       if ((evnt.dc.selectedRecords.length == 1) ) { var btn = this._getElement_("btnRunImportItem"); if(btn) btn.enable();  } else { var btn = this._getElement_("btnRunImportItem");if(btn) btn.disable();  }
			 }, this );					 	
		this._elems_.add("jobFilter", { xtype:"net.nan21.dnet.module.ad.impex.dc.ImportJob$Filter", id:Ext.id(), _controller_:this._dcs_.get("job") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("jobList", { xtype:"net.nan21.dnet.module.ad.impex.dc.ImportJob$List", id:Ext.id(), _controller_:this._dcs_.get("job") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("jobEdit", { xtype:"net.nan21.dnet.module.ad.impex.dc.ImportJob$Edit", id:Ext.id(), _controller_:this._dcs_.get("job"),height:100,buttons:[ this._elems_.get("btnRunImport") ,this._elems_.get("btnRunImportItem") ] ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("job").isRecordValid = this._dcs_.get("job").isRecordValid.createInterceptor(function() { return this._getElement_("jobEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("itemEditList", { xtype:"net.nan21.dnet.module.ad.impex.dc.ImportJobItem$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("item") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("jobFilter")["region"] = "north";			
			this._elems_.get("jobList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("jobFilter") , this._elems_.get("jobList") ]; 				 		
 
			this._elems_.get("jobEdit")["region"] = "north";			
			this._elems_.get("itemEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("jobEdit") , this._elems_.get("itemEditList") ]; 				 		
	 	this._linkToolbar_("tlbJobList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbJobEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbItemEditList", "itemEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbJobList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("job").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-load"
		this._tlbitms_.add("tlbJobList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbJobList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobList-edit_sr"
		this._tlbitms_.add("tlbJobList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("job").doNew(); this._invokeTlbItem_("tlbJobList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobList-new_sr"
		this._tlbitms_.add("tlbJobList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").doCopy(); this._invokeTlbItem_("tlbJobList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobList-copy_sr"
		this._tlbitms_.add("tlbJobList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobList-delete_selected_sr"
		this._tlbitms_.add("tlbJobList___S00_", "-") ;
		this._tlbitms_.add("tlbJobList___S01_", "-") ;
		this._tlbitms_.add("tlbJobList___TITLE_",  {xtype:"tbtext", text:"ImportJob"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbJobList__") != -1); } )
		this._tlbs_.add("tlbJobList" , t.getRange() );

		this._getDc_("job").on("onEdit", function() {this._invokeTlbItem_("tlbJobList__edit_sr");} , this);

	


			this._getDc_("job").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbJobList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("job").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbJobList__load")) this._tlbitms_.get("tlbJobList__load").enable();
                 if(this._tlbitms_.get("tlbJobList__new_sr"))this._tlbitms_.get("tlbJobList__new_sr").enable();
                 if(this._tlbitms_.get("tlbJobList__new_mr"))this._tlbitms_.get("tlbJobList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("job").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbJobList__edit_sr")) this._tlbitms_.get("tlbJobList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbJobList__copy_sr")) this._tlbitms_.get("tlbJobList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbJobList__delete_selected_sr")) this._tlbitms_.get("tlbJobList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbJobList__edit_sr")) this._tlbitms_.get("tlbJobList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbJobList__copy_sr")) this._tlbitms_.get("tlbJobList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbJobList__delete_selected_sr")) this._tlbitms_.get("tlbJobList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbJobEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("job")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbJobEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobEdit-back_sr"
		this._tlbitms_.add("tlbJobEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobEdit-save"
		this._tlbitms_.add("tlbJobEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("job").doNew(); this._invokeTlbItem_("tlbJobEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobEdit-new_sr"
		this._tlbitms_.add("tlbJobEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("job").doCopy(); this._invokeTlbItem_("tlbJobEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobEdit-copy_sr"
		this._tlbitms_.add("tlbJobEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("job").getCurrentRecord().phantom) {this._getDc_("job").discardChanges();this._invokeTlbItem_("tlbJobEdit__back_sr");} else  {this._getDc_("job").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobEdit-rollback_sr"
		this._tlbitms_.add("tlbJobEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("job").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbJobEdit-prev_rec_sr"
		this._tlbitms_.add("tlbJobEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("job").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbJobEdit-next_rec_sr"
		this._tlbitms_.add("tlbJobEdit___S00_", "-") ;
		this._tlbitms_.add("tlbJobEdit___S01_", "-") ;
		this._tlbitms_.add("tlbJobEdit___TITLE_",  {xtype:"tbtext", text:"ImportJob"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbJobEdit__") != -1); } )
		this._tlbs_.add("tlbJobEdit" , t.getRange() );
	


			this._getDc_("job").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbJobEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("job").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbJobEdit__load")) this._tlbitms_.get("tlbJobEdit__load").enable();
                 if(this._tlbitms_.get("tlbJobEdit__new_sr"))this._tlbitms_.get("tlbJobEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbJobEdit__new_mr"))this._tlbitms_.get("tlbJobEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("job").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbJobEdit__back_sr")) this._tlbitms_.get("tlbJobEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__save")) this._tlbitms_.get("tlbJobEdit__save").enable();
                    if(this._tlbitms_.get("tlbJobEdit__new_sr")) this._tlbitms_.get("tlbJobEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__copy_sr")) this._tlbitms_.get("tlbJobEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__rollback_record_sr")) this._tlbitms_.get("tlbJobEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbJobEdit__rollback_sr")) this._tlbitms_.get("tlbJobEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbJobEdit__prev_rec_sr")) this._tlbitms_.get("tlbJobEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__next_rec_sr")) this._tlbitms_.get("tlbJobEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("job").on("cleanRecord" , function() {
		  		  if (this._getDc_("job").isDirty() ) {
                    if(this._tlbitms_.get("tlbJobEdit__back_sr")) this._tlbitms_.get("tlbJobEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__save")) this._tlbitms_.get("tlbJobEdit__save").enable();
                    if(this._tlbitms_.get("tlbJobEdit__new_sr")) this._tlbitms_.get("tlbJobEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__copy_sr")) this._tlbitms_.get("tlbJobEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__rollback_record_sr")) this._tlbitms_.get("tlbJobEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbJobEdit__rollback_sr")) this._tlbitms_.get("tlbJobEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbJobEdit__prev_rec_sr")) this._tlbitms_.get("tlbJobEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbJobEdit__next_rec_sr")) this._tlbitms_.get("tlbJobEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbJobEdit__back_sr")) this._tlbitms_.get("tlbJobEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbJobEdit__save")) this._tlbitms_.get("tlbJobEdit__save").disable();
                  	if(this._tlbitms_.get("tlbJobEdit__new_sr")) this._tlbitms_.get("tlbJobEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbJobEdit__copy_sr")) this._tlbitms_.get("tlbJobEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbJobEdit__rollback_record_sr")) this._tlbitms_.get("tlbJobEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbJobEdit__rollback_sr")) this._tlbitms_.get("tlbJobEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbJobEdit__prev_rec_sr")) this._tlbitms_.get("tlbJobEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbJobEdit__next_rec_sr")) this._tlbitms_.get("tlbJobEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("job").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbJobEdit__copy_sr")) this._tlbitms_.get("tlbJobEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbItemEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("item").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-load"
		this._tlbitms_.add("tlbItemEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbItemEditList-save_mr"
		this._tlbitms_.add("tlbItemEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("item").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-new_mr"
		this._tlbitms_.add("tlbItemEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-copy_mr"
		this._tlbitms_.add("tlbItemEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("item").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-delete_mr"
		this._tlbitms_.add("tlbItemEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("item").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbItemEditList-rollback_mr"
		this._tlbitms_.add("tlbItemEditList___S00_", "-") ;
		this._tlbitms_.add("tlbItemEditList___S01_", "-") ;
		this._tlbitms_.add("tlbItemEditList___TITLE_",  {xtype:"tbtext", text:"ImportJobItem"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbItemEditList__") != -1); } )
		this._tlbs_.add("tlbItemEditList" , t.getRange() );
	


			this._getDc_("item").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbItemEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("item").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").enable();
                 if(this._tlbitms_.get("tlbItemEditList__new_sr"))this._tlbitms_.get("tlbItemEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbItemEditList__new_mr"))this._tlbitms_.get("tlbItemEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("item").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbItemEditList__copy_mr")) this._tlbitms_.get("tlbItemEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbItemEditList__delete_mr")) this._tlbitms_.get("tlbItemEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbItemEditList__copy_mr")) this._tlbitms_.get("tlbItemEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbItemEditList__delete_mr")) this._tlbitms_.get("tlbItemEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("item").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbItemEditList__save_mr")) this._tlbitms_.get("tlbItemEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("item").on("cleanRecord" , function() {
		  		  if (this._getDc_("item").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbItemEditList__save_mr"))this._tlbitms_.get("tlbItemEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbItemEditList__load")) this._tlbitms_.get("tlbItemEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbItemEditList__back_mr"))this._tlbitms_.get("tlbItemEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbItemEditList__save_mr"))this._tlbitms_.get("tlbItemEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbItemEditList__rollback_record_mr"))this._tlbitms_.get("tlbItemEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbItemEditList__rollback_mr"))this._tlbitms_.get("tlbItemEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("job").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("jobEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("item").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.ad.impex.frame.ImportJob_UI", net.nan21.dnet.module.ad.impex.frame.ImportJob_UI);   
