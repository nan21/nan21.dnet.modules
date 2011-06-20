 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/GradeRateDs", "nan21.dnet.module.hr.ui.extjs/dc/GradeRate", "nan21.dnet.module.hr.ui.extjs/ds/GradeRateValueDs", "nan21.dnet.module.hr.ui.extjs/dc/GradeRateValue","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.hr.ui.extjs/ds/GradeLovDs","nan21.dnet.module.hr.ui.extjs/lov/Grades"]);

Ext.ns("net.nan21.dnet.module.hr.grade.frame");
net.nan21.dnet.module.hr.grade.frame.GradeRate_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.grade.frame.GradeRate_UI"
	
	,_defineDcs_: function () {	
		var  rate = new net.nan21.dnet.module.hr.grade.dc.GradeRate({multiEdit:false}), value = new net.nan21.dnet.module.hr.grade.dc.GradeRateValue({multiEdit:true});	 	
		
		this._dcs_.add("rate", rate);			
		value.setDcContext(new dnet.base.DcContext({childDc:value, parentDc:rate, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"gradeRateId", parentField:"id"} ]}}));rate.addChild(value);
		this._dcs_.add("value", value);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("rateFilter", { xtype:"net.nan21.dnet.module.hr.grade.dc.GradeRate$Filter", id:Ext.id(), _controller_:this._dcs_.get("rate") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("rateList", { xtype:"net.nan21.dnet.module.hr.grade.dc.GradeRate$List", id:Ext.id(), _controller_:this._dcs_.get("rate") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("rateEdit", { xtype:"net.nan21.dnet.module.hr.grade.dc.GradeRate$Edit", id:Ext.id(), _controller_:this._dcs_.get("rate"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("rate").isRecordValid = this._dcs_.get("rate").isRecordValid.createInterceptor(function() { return this._getElement_("rateEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("valueEditList", { xtype:"net.nan21.dnet.module.hr.grade.dc.GradeRateValue$CtxEditList4GradeRate", frame:true, id:Ext.id(), _controller_:this._dcs_.get("value") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("rateFilter")["region"] = "north";			
			this._elems_.get("rateList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("rateFilter") , this._elems_.get("rateList") ]; 				 		
 
			this._elems_.get("rateEdit")["region"] = "north";			
			this._elems_.get("valueEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("rateEdit") , this._elems_.get("valueEditList") ]; 				 		
	 	this._linkToolbar_("tlbRateList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbRateEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbValueEditList", "valueEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbRateList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("rate").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRateList-load"
		this._tlbitms_.add("tlbRateList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rate")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbRateList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRateList-edit_sr"
		this._tlbitms_.add("tlbRateList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("rate").doNew(); this._invokeTlbItem_("tlbRateList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRateList-new_sr"
		this._tlbitms_.add("tlbRateList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rate").doCopy(); this._invokeTlbItem_("tlbRateList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRateList-copy_sr"
		this._tlbitms_.add("tlbRateList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rate").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRateList-delete_selected_sr"
		this._tlbitms_.add("tlbRateList___S00_", "-") ;
		this._tlbitms_.add("tlbRateList___S01_", "-") ;
		this._tlbitms_.add("tlbRateList___TITLE_",  {xtype:"tbtext", text:"GradeRate"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRateList__") != -1); } )
		this._tlbs_.add("tlbRateList" , t.getRange() );

		this._getDc_("rate").on("onEdit", function() {this._invokeTlbItem_("tlbRateList__edit_sr");} , this);

	


			this._getDc_("rate").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbRateList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("rate").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbRateList__load")) this._tlbitms_.get("tlbRateList__load").enable();
                 if(this._tlbitms_.get("tlbRateList__new_sr"))this._tlbitms_.get("tlbRateList__new_sr").enable();
                 if(this._tlbitms_.get("tlbRateList__new_mr"))this._tlbitms_.get("tlbRateList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("rate").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbRateList__edit_sr")) this._tlbitms_.get("tlbRateList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbRateList__copy_sr")) this._tlbitms_.get("tlbRateList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbRateList__delete_selected_sr")) this._tlbitms_.get("tlbRateList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbRateList__edit_sr")) this._tlbitms_.get("tlbRateList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbRateList__copy_sr")) this._tlbitms_.get("tlbRateList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbRateList__delete_selected_sr")) this._tlbitms_.get("tlbRateList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbRateEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("rate")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbRateEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRateEdit-back_sr"
		this._tlbitms_.add("tlbRateEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rate").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRateEdit-save"
		this._tlbitms_.add("tlbRateEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("rate").doNew(); this._invokeTlbItem_("tlbRateEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRateEdit-new_sr"
		this._tlbitms_.add("tlbRateEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("rate").doCopy(); this._invokeTlbItem_("tlbRateEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRateEdit-copy_sr"
		this._tlbitms_.add("tlbRateEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("rate").getCurrentRecord().phantom) {this._getDc_("rate").discardChanges();this._invokeTlbItem_("tlbRateEdit__back_sr");} else  {this._getDc_("rate").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRateEdit-rollback_sr"
		this._tlbitms_.add("tlbRateEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("rate").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbRateEdit-prev_rec_sr"
		this._tlbitms_.add("tlbRateEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("rate").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbRateEdit-next_rec_sr"
		this._tlbitms_.add("tlbRateEdit___S00_", "-") ;
		this._tlbitms_.add("tlbRateEdit___S01_", "-") ;
		this._tlbitms_.add("tlbRateEdit___TITLE_",  {xtype:"tbtext", text:"GradeRate"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbRateEdit__") != -1); } )
		this._tlbs_.add("tlbRateEdit" , t.getRange() );
	


			this._getDc_("rate").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbRateEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("rate").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbRateEdit__load")) this._tlbitms_.get("tlbRateEdit__load").enable();
                 if(this._tlbitms_.get("tlbRateEdit__new_sr"))this._tlbitms_.get("tlbRateEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbRateEdit__new_mr"))this._tlbitms_.get("tlbRateEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("rate").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbRateEdit__back_sr")) this._tlbitms_.get("tlbRateEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbRateEdit__save")) this._tlbitms_.get("tlbRateEdit__save").enable();
                    if(this._tlbitms_.get("tlbRateEdit__new_sr")) this._tlbitms_.get("tlbRateEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbRateEdit__copy_sr")) this._tlbitms_.get("tlbRateEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbRateEdit__rollback_record_sr")) this._tlbitms_.get("tlbRateEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbRateEdit__rollback_sr")) this._tlbitms_.get("tlbRateEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbRateEdit__prev_rec_sr")) this._tlbitms_.get("tlbRateEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbRateEdit__next_rec_sr")) this._tlbitms_.get("tlbRateEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("rate").on("cleanRecord" , function() {
		  		  if (this._getDc_("rate").isDirty() ) {
                    if(this._tlbitms_.get("tlbRateEdit__back_sr")) this._tlbitms_.get("tlbRateEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbRateEdit__save")) this._tlbitms_.get("tlbRateEdit__save").enable();
                    if(this._tlbitms_.get("tlbRateEdit__new_sr")) this._tlbitms_.get("tlbRateEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbRateEdit__copy_sr")) this._tlbitms_.get("tlbRateEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbRateEdit__rollback_record_sr")) this._tlbitms_.get("tlbRateEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbRateEdit__rollback_sr")) this._tlbitms_.get("tlbRateEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbRateEdit__prev_rec_sr")) this._tlbitms_.get("tlbRateEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbRateEdit__next_rec_sr")) this._tlbitms_.get("tlbRateEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbRateEdit__back_sr")) this._tlbitms_.get("tlbRateEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbRateEdit__save")) this._tlbitms_.get("tlbRateEdit__save").disable();
                  	if(this._tlbitms_.get("tlbRateEdit__new_sr")) this._tlbitms_.get("tlbRateEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbRateEdit__copy_sr")) this._tlbitms_.get("tlbRateEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbRateEdit__rollback_record_sr")) this._tlbitms_.get("tlbRateEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbRateEdit__rollback_sr")) this._tlbitms_.get("tlbRateEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbRateEdit__prev_rec_sr")) this._tlbitms_.get("tlbRateEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbRateEdit__next_rec_sr")) this._tlbitms_.get("tlbRateEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("rate").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbRateEdit__copy_sr")) this._tlbitms_.get("tlbRateEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbValueEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("value").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbValueEditList-load"
		this._tlbitms_.add("tlbValueEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("value").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbValueEditList-save_mr"
		this._tlbitms_.add("tlbValueEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("value").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbValueEditList-new_mr"
		this._tlbitms_.add("tlbValueEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("value").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbValueEditList-copy_mr"
		this._tlbitms_.add("tlbValueEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("value").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbValueEditList-delete_mr"
		this._tlbitms_.add("tlbValueEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("value").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbValueEditList-rollback_mr"
		this._tlbitms_.add("tlbValueEditList___S00_", "-") ;
		this._tlbitms_.add("tlbValueEditList___S01_", "-") ;
		this._tlbitms_.add("tlbValueEditList___TITLE_",  {xtype:"tbtext", text:"GradeRateValue"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbValueEditList__") != -1); } )
		this._tlbs_.add("tlbValueEditList" , t.getRange() );
	


			this._getDc_("value").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbValueEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("value").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbValueEditList__load")) this._tlbitms_.get("tlbValueEditList__load").enable();
                 if(this._tlbitms_.get("tlbValueEditList__new_sr"))this._tlbitms_.get("tlbValueEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbValueEditList__new_mr"))this._tlbitms_.get("tlbValueEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("value").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbValueEditList__copy_mr")) this._tlbitms_.get("tlbValueEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbValueEditList__delete_mr")) this._tlbitms_.get("tlbValueEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbValueEditList__copy_mr")) this._tlbitms_.get("tlbValueEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbValueEditList__delete_mr")) this._tlbitms_.get("tlbValueEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("value").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbValueEditList__load")) this._tlbitms_.get("tlbValueEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbValueEditList__save_mr")) this._tlbitms_.get("tlbValueEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbValueEditList__rollback_record_mr"))this._tlbitms_.get("tlbValueEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbValueEditList__rollback_mr"))this._tlbitms_.get("tlbValueEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("value").on("cleanRecord" , function() {
		  		  if (this._getDc_("value").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbValueEditList__load")) this._tlbitms_.get("tlbValueEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbValueEditList__save_mr"))this._tlbitms_.get("tlbValueEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbValueEditList__rollback_record_mr"))this._tlbitms_.get("tlbValueEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbValueEditList__rollback_mr"))this._tlbitms_.get("tlbValueEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbValueEditList__load")) this._tlbitms_.get("tlbValueEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbValueEditList__back_mr"))this._tlbitms_.get("tlbValueEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbValueEditList__save_mr"))this._tlbitms_.get("tlbValueEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbValueEditList__rollback_record_mr"))this._tlbitms_.get("tlbValueEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbValueEditList__rollback_mr"))this._tlbitms_.get("tlbValueEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("rate").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("rateEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("value").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.grade.frame.GradeRate_UI", net.nan21.dnet.module.hr.grade.frame.GradeRate_UI);   
