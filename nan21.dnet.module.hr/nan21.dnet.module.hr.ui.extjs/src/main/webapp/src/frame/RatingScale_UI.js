 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/RatingScaleDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingScale", "nan21.dnet.module.hr.ui.extjs/ds/RatingLevelDs", "nan21.dnet.module.hr.ui.extjs/dc/RatingLevel"]);

Ext.ns("net.nan21.dnet.module.hr.skill.frame");
net.nan21.dnet.module.hr.skill.frame.RatingScale_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.skill.frame.RatingScale_UI"
	
	,_defineDcs_: function () {	
		var  scale = new net.nan21.dnet.module.hr.skill.dc.RatingScale({multiEdit:false}), level = new net.nan21.dnet.module.hr.skill.dc.RatingLevel({multiEdit:true});	 	
		
		this._dcs_.add("scale", scale);			
		level.setDcContext(new dnet.base.DcContext({childDc:level, parentDc:scale, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"ratingScaleId", parentField:"id"} ]}}));scale.addChild(level);
		this._dcs_.add("level", level);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("scaleFilter", { xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$Filter", id:Ext.id(), _controller_:this._dcs_.get("scale") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("scaleList", { xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$List", id:Ext.id(), _controller_:this._dcs_.get("scale") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("scaleEdit", { xtype:"net.nan21.dnet.module.hr.skill.dc.RatingScale$Edit", id:Ext.id(), _controller_:this._dcs_.get("scale"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("scale").isRecordValid = this._dcs_.get("scale").isRecordValid.createInterceptor(function() { return this._getElement_("scaleEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("levelCtxEditList", { xtype:"net.nan21.dnet.module.hr.skill.dc.RatingLevel$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("level"),title:"Proficiency levels" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("scaleFilter")["region"] = "north";			
			this._elems_.get("scaleList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("scaleFilter") , this._elems_.get("scaleList") ]; 				 		
 
			this._elems_.get("scaleEdit")["region"] = "north";			
			this._elems_.get("levelCtxEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("scaleEdit") , this._elems_.get("levelCtxEditList") ]; 				 		
	 	this._linkToolbar_("tlbScaleList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbScaleEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbLevelCtxEditList", "levelCtxEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbScaleList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("scale").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbScaleList-load"
		this._tlbitms_.add("tlbScaleList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("scale")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbScaleList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbScaleList-edit_sr"
		this._tlbitms_.add("tlbScaleList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("scale").doNew(); this._invokeTlbItem_("tlbScaleList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbScaleList-new_sr"
		this._tlbitms_.add("tlbScaleList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("scale").doCopy(); this._invokeTlbItem_("tlbScaleList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbScaleList-copy_sr"
		this._tlbitms_.add("tlbScaleList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("scale").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbScaleList-delete_selected_sr"
		this._tlbitms_.add("tlbScaleList___S00_", "-") ;
		this._tlbitms_.add("tlbScaleList___S01_", "-") ;
		this._tlbitms_.add("tlbScaleList___TITLE_",  {xtype:"tbtext", text:"RatingScale"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbScaleList__") != -1); } )
		this._tlbs_.add("tlbScaleList" , t.getRange() );

		this._getDc_("scale").on("onEdit", function() {this._invokeTlbItem_("tlbScaleList__edit_sr");} , this);

	


			this._getDc_("scale").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbScaleList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("scale").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbScaleList__load")) this._tlbitms_.get("tlbScaleList__load").enable();
                 if(this._tlbitms_.get("tlbScaleList__new_sr"))this._tlbitms_.get("tlbScaleList__new_sr").enable();
                 if(this._tlbitms_.get("tlbScaleList__new_mr"))this._tlbitms_.get("tlbScaleList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("scale").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbScaleList__edit_sr")) this._tlbitms_.get("tlbScaleList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbScaleList__copy_sr")) this._tlbitms_.get("tlbScaleList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbScaleList__delete_selected_sr")) this._tlbitms_.get("tlbScaleList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbScaleList__edit_sr")) this._tlbitms_.get("tlbScaleList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbScaleList__copy_sr")) this._tlbitms_.get("tlbScaleList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbScaleList__delete_selected_sr")) this._tlbitms_.get("tlbScaleList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbScaleEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("scale")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbScaleEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbScaleEdit-back_sr"
		this._tlbitms_.add("tlbScaleEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("scale").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbScaleEdit-save"
		this._tlbitms_.add("tlbScaleEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("scale").doNew(); this._invokeTlbItem_("tlbScaleEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbScaleEdit-new_sr"
		this._tlbitms_.add("tlbScaleEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("scale").doCopy(); this._invokeTlbItem_("tlbScaleEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbScaleEdit-copy_sr"
		this._tlbitms_.add("tlbScaleEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("scale").getCurrentRecord().phantom) {this._getDc_("scale").discardChanges();this._invokeTlbItem_("tlbScaleEdit__back_sr");} else  {this._getDc_("scale").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbScaleEdit-rollback_sr"
		this._tlbitms_.add("tlbScaleEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("scale").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbScaleEdit-prev_rec_sr"
		this._tlbitms_.add("tlbScaleEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("scale").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbScaleEdit-next_rec_sr"
		this._tlbitms_.add("tlbScaleEdit___S00_", "-") ;
		this._tlbitms_.add("tlbScaleEdit___S01_", "-") ;
		this._tlbitms_.add("tlbScaleEdit___TITLE_",  {xtype:"tbtext", text:"RatingScale"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbScaleEdit__") != -1); } )
		this._tlbs_.add("tlbScaleEdit" , t.getRange() );
	


			this._getDc_("scale").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbScaleEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("scale").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbScaleEdit__load")) this._tlbitms_.get("tlbScaleEdit__load").enable();
                 if(this._tlbitms_.get("tlbScaleEdit__new_sr"))this._tlbitms_.get("tlbScaleEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbScaleEdit__new_mr"))this._tlbitms_.get("tlbScaleEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("scale").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbScaleEdit__back_sr")) this._tlbitms_.get("tlbScaleEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbScaleEdit__save")) this._tlbitms_.get("tlbScaleEdit__save").enable();
                    if(this._tlbitms_.get("tlbScaleEdit__new_sr")) this._tlbitms_.get("tlbScaleEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbScaleEdit__copy_sr")) this._tlbitms_.get("tlbScaleEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbScaleEdit__rollback_record_sr")) this._tlbitms_.get("tlbScaleEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbScaleEdit__rollback_sr")) this._tlbitms_.get("tlbScaleEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbScaleEdit__prev_rec_sr")) this._tlbitms_.get("tlbScaleEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbScaleEdit__next_rec_sr")) this._tlbitms_.get("tlbScaleEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("scale").on("cleanRecord" , function() {
		  		  if (this._getDc_("scale").isDirty() ) {
                    if(this._tlbitms_.get("tlbScaleEdit__back_sr")) this._tlbitms_.get("tlbScaleEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbScaleEdit__save")) this._tlbitms_.get("tlbScaleEdit__save").enable();
                    if(this._tlbitms_.get("tlbScaleEdit__new_sr")) this._tlbitms_.get("tlbScaleEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbScaleEdit__copy_sr")) this._tlbitms_.get("tlbScaleEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbScaleEdit__rollback_record_sr")) this._tlbitms_.get("tlbScaleEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbScaleEdit__rollback_sr")) this._tlbitms_.get("tlbScaleEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbScaleEdit__prev_rec_sr")) this._tlbitms_.get("tlbScaleEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbScaleEdit__next_rec_sr")) this._tlbitms_.get("tlbScaleEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbScaleEdit__back_sr")) this._tlbitms_.get("tlbScaleEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbScaleEdit__save")) this._tlbitms_.get("tlbScaleEdit__save").disable();
                  	if(this._tlbitms_.get("tlbScaleEdit__new_sr")) this._tlbitms_.get("tlbScaleEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbScaleEdit__copy_sr")) this._tlbitms_.get("tlbScaleEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbScaleEdit__rollback_record_sr")) this._tlbitms_.get("tlbScaleEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbScaleEdit__rollback_sr")) this._tlbitms_.get("tlbScaleEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbScaleEdit__prev_rec_sr")) this._tlbitms_.get("tlbScaleEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbScaleEdit__next_rec_sr")) this._tlbitms_.get("tlbScaleEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("scale").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbScaleEdit__copy_sr")) this._tlbitms_.get("tlbScaleEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbLevelCtxEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("level").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLevelCtxEditList-load"
		this._tlbitms_.add("tlbLevelCtxEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("level").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbLevelCtxEditList-save_mr"
		this._tlbitms_.add("tlbLevelCtxEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("level").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLevelCtxEditList-new_mr"
		this._tlbitms_.add("tlbLevelCtxEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("level").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLevelCtxEditList-copy_mr"
		this._tlbitms_.add("tlbLevelCtxEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("level").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLevelCtxEditList-delete_mr"
		this._tlbitms_.add("tlbLevelCtxEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("level").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbLevelCtxEditList-rollback_mr"
		this._tlbitms_.add("tlbLevelCtxEditList___S00_", "-") ;
		this._tlbitms_.add("tlbLevelCtxEditList___S01_", "-") ;
		this._tlbitms_.add("tlbLevelCtxEditList___TITLE_",  {xtype:"tbtext", text:"RatingLevel"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbLevelCtxEditList__") != -1); } )
		this._tlbs_.add("tlbLevelCtxEditList" , t.getRange() );
	


			this._getDc_("level").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbLevelCtxEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("level").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbLevelCtxEditList__load")) this._tlbitms_.get("tlbLevelCtxEditList__load").enable();
                 if(this._tlbitms_.get("tlbLevelCtxEditList__new_sr"))this._tlbitms_.get("tlbLevelCtxEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbLevelCtxEditList__new_mr"))this._tlbitms_.get("tlbLevelCtxEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("level").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbLevelCtxEditList__copy_mr")) this._tlbitms_.get("tlbLevelCtxEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbLevelCtxEditList__delete_mr")) this._tlbitms_.get("tlbLevelCtxEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbLevelCtxEditList__copy_mr")) this._tlbitms_.get("tlbLevelCtxEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbLevelCtxEditList__delete_mr")) this._tlbitms_.get("tlbLevelCtxEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("level").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbLevelCtxEditList__load")) this._tlbitms_.get("tlbLevelCtxEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbLevelCtxEditList__save_mr")) this._tlbitms_.get("tlbLevelCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbLevelCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbLevelCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbLevelCtxEditList__rollback_mr"))this._tlbitms_.get("tlbLevelCtxEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("level").on("cleanRecord" , function() {
		  		  if (this._getDc_("level").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbLevelCtxEditList__load")) this._tlbitms_.get("tlbLevelCtxEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbLevelCtxEditList__save_mr"))this._tlbitms_.get("tlbLevelCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbLevelCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbLevelCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbLevelCtxEditList__rollback_mr"))this._tlbitms_.get("tlbLevelCtxEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbLevelCtxEditList__load")) this._tlbitms_.get("tlbLevelCtxEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbLevelCtxEditList__back_mr"))this._tlbitms_.get("tlbLevelCtxEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbLevelCtxEditList__save_mr"))this._tlbitms_.get("tlbLevelCtxEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbLevelCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbLevelCtxEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbLevelCtxEditList__rollback_mr"))this._tlbitms_.get("tlbLevelCtxEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("scale").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("scaleEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("level").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.skill.frame.RatingScale_UI", net.nan21.dnet.module.hr.skill.frame.RatingScale_UI);   
