 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleRateDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScaleRate", "nan21.dnet.module.hr.ui.extjs/ds/PayScaleRateValueDs", "nan21.dnet.module.hr.ui.extjs/dc/PayScaleRateValue","nan21.dnet.module.hr.ui.extjs/ds/PayScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayScales","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.hr.ui.extjs/ds/PayScaleLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayScales","nan21.dnet.module.bd.ui.extjs/ds/CurrencyLovDs","nan21.dnet.module.bd.ui.extjs/lov/Currencies","nan21.dnet.module.hr.ui.extjs/ds/PayScalePointLovDs","nan21.dnet.module.hr.ui.extjs/lov/PayScalePoints"]);

Ext.ns("net.nan21.dnet.module.hr.grade.frame");
net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI"
	
	,_defineDcs_: function () {	
		var  srate = new net.nan21.dnet.module.hr.grade.dc.PayScaleRate({multiEdit:false}), value = new net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue({multiEdit:true});	 	
		
		this._dcs_.add("srate", srate);			
		value.setDcContext(new dnet.base.DcContext({childDc:value, parentDc:srate, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"scaleRateId", parentField:"id"} ]}}));srate.addChild(value);
		this._dcs_.add("value", value);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("srateFilter", { xtype:"net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Filter", id:Ext.id(), _controller_:this._dcs_.get("srate") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("srateList", { xtype:"net.nan21.dnet.module.hr.grade.dc.PayScaleRate$List", id:Ext.id(), _controller_:this._dcs_.get("srate") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("srateEdit", { xtype:"net.nan21.dnet.module.hr.grade.dc.PayScaleRate$Edit", id:Ext.id(), _controller_:this._dcs_.get("srate"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("srate").isRecordValid = this._dcs_.get("srate").isRecordValid.createInterceptor(function() { return this._getElement_("srateEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("valueEditList", { xtype:"net.nan21.dnet.module.hr.grade.dc.PayScaleRateValue$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("value"),title:"Progression point rates" ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("srateFilter")["region"] = "north";			
			this._elems_.get("srateList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("srateFilter") , this._elems_.get("srateList") ]; 				 		
 
			this._elems_.get("srateEdit")["region"] = "north";			
			this._elems_.get("valueEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("srateEdit") , this._elems_.get("valueEditList") ]; 				 		
	 	this._linkToolbar_("tlbSrateList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbSrateEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbSalueEditList", "valueEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbSrateList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("srate").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSrateList-load"
		this._tlbitms_.add("tlbSrateList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("srate")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbSrateList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSrateList-edit_sr"
		this._tlbitms_.add("tlbSrateList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("srate").doNew(); this._invokeTlbItem_("tlbSrateList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSrateList-new_sr"
		this._tlbitms_.add("tlbSrateList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("srate").doCopy(); this._invokeTlbItem_("tlbSrateList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSrateList-copy_sr"
		this._tlbitms_.add("tlbSrateList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("srate").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSrateList-delete_selected_sr"
		this._tlbitms_.add("tlbSrateList___S00_", "-") ;
		this._tlbitms_.add("tlbSrateList___S01_", "-") ;
		this._tlbitms_.add("tlbSrateList___TITLE_",  {xtype:"tbtext", text:"PayScaleRate"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbSrateList__") != -1); } )
		this._tlbs_.add("tlbSrateList" , t.getRange() );

		this._getDc_("srate").on("onEdit", function() {this._invokeTlbItem_("tlbSrateList__edit_sr");} , this);

	


			this._getDc_("srate").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbSrateList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("srate").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbSrateList__load")) this._tlbitms_.get("tlbSrateList__load").enable();
                 if(this._tlbitms_.get("tlbSrateList__new_sr"))this._tlbitms_.get("tlbSrateList__new_sr").enable();
                 if(this._tlbitms_.get("tlbSrateList__new_mr"))this._tlbitms_.get("tlbSrateList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("srate").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbSrateList__edit_sr")) this._tlbitms_.get("tlbSrateList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbSrateList__copy_sr")) this._tlbitms_.get("tlbSrateList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbSrateList__delete_selected_sr")) this._tlbitms_.get("tlbSrateList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbSrateList__edit_sr")) this._tlbitms_.get("tlbSrateList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbSrateList__copy_sr")) this._tlbitms_.get("tlbSrateList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbSrateList__delete_selected_sr")) this._tlbitms_.get("tlbSrateList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbSrateEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("srate")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbSrateEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSrateEdit-back_sr"
		this._tlbitms_.add("tlbSrateEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("srate").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSrateEdit-save"
		this._tlbitms_.add("tlbSrateEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("srate").doNew(); this._invokeTlbItem_("tlbSrateEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSrateEdit-new_sr"
		this._tlbitms_.add("tlbSrateEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("srate").doCopy(); this._invokeTlbItem_("tlbSrateEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSrateEdit-copy_sr"
		this._tlbitms_.add("tlbSrateEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("srate").getCurrentRecord().phantom) {this._getDc_("srate").discardChanges();this._invokeTlbItem_("tlbSrateEdit__back_sr");} else  {this._getDc_("srate").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSrateEdit-rollback_sr"
		this._tlbitms_.add("tlbSrateEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("srate").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSrateEdit-prev_rec_sr"
		this._tlbitms_.add("tlbSrateEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("srate").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSrateEdit-next_rec_sr"
		this._tlbitms_.add("tlbSrateEdit___S00_", "-") ;
		this._tlbitms_.add("tlbSrateEdit___S01_", "-") ;
		this._tlbitms_.add("tlbSrateEdit___TITLE_",  {xtype:"tbtext", text:"PayScaleRate"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbSrateEdit__") != -1); } )
		this._tlbs_.add("tlbSrateEdit" , t.getRange() );
	


			this._getDc_("srate").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbSrateEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("srate").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbSrateEdit__load")) this._tlbitms_.get("tlbSrateEdit__load").enable();
                 if(this._tlbitms_.get("tlbSrateEdit__new_sr"))this._tlbitms_.get("tlbSrateEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbSrateEdit__new_mr"))this._tlbitms_.get("tlbSrateEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("srate").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbSrateEdit__back_sr")) this._tlbitms_.get("tlbSrateEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbSrateEdit__save")) this._tlbitms_.get("tlbSrateEdit__save").enable();
                    if(this._tlbitms_.get("tlbSrateEdit__new_sr")) this._tlbitms_.get("tlbSrateEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbSrateEdit__copy_sr")) this._tlbitms_.get("tlbSrateEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbSrateEdit__rollback_record_sr")) this._tlbitms_.get("tlbSrateEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbSrateEdit__rollback_sr")) this._tlbitms_.get("tlbSrateEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbSrateEdit__prev_rec_sr")) this._tlbitms_.get("tlbSrateEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbSrateEdit__next_rec_sr")) this._tlbitms_.get("tlbSrateEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("srate").on("cleanRecord" , function() {
		  		  if (this._getDc_("srate").isDirty() ) {
                    if(this._tlbitms_.get("tlbSrateEdit__back_sr")) this._tlbitms_.get("tlbSrateEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbSrateEdit__save")) this._tlbitms_.get("tlbSrateEdit__save").enable();
                    if(this._tlbitms_.get("tlbSrateEdit__new_sr")) this._tlbitms_.get("tlbSrateEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbSrateEdit__copy_sr")) this._tlbitms_.get("tlbSrateEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbSrateEdit__rollback_record_sr")) this._tlbitms_.get("tlbSrateEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbSrateEdit__rollback_sr")) this._tlbitms_.get("tlbSrateEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbSrateEdit__prev_rec_sr")) this._tlbitms_.get("tlbSrateEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbSrateEdit__next_rec_sr")) this._tlbitms_.get("tlbSrateEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbSrateEdit__back_sr")) this._tlbitms_.get("tlbSrateEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbSrateEdit__save")) this._tlbitms_.get("tlbSrateEdit__save").disable();
                  	if(this._tlbitms_.get("tlbSrateEdit__new_sr")) this._tlbitms_.get("tlbSrateEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbSrateEdit__copy_sr")) this._tlbitms_.get("tlbSrateEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbSrateEdit__rollback_record_sr")) this._tlbitms_.get("tlbSrateEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbSrateEdit__rollback_sr")) this._tlbitms_.get("tlbSrateEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbSrateEdit__prev_rec_sr")) this._tlbitms_.get("tlbSrateEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbSrateEdit__next_rec_sr")) this._tlbitms_.get("tlbSrateEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("srate").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbSrateEdit__copy_sr")) this._tlbitms_.get("tlbSrateEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbSalueEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("value").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSalueEditList-load"
		this._tlbitms_.add("tlbSalueEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("value").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbSalueEditList-save_mr"
		this._tlbitms_.add("tlbSalueEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("value").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSalueEditList-new_mr"
		this._tlbitms_.add("tlbSalueEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("value").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSalueEditList-copy_mr"
		this._tlbitms_.add("tlbSalueEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("value").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSalueEditList-delete_mr"
		this._tlbitms_.add("tlbSalueEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("value").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbSalueEditList-rollback_mr"
		this._tlbitms_.add("tlbSalueEditList___S00_", "-") ;
		this._tlbitms_.add("tlbSalueEditList___S01_", "-") ;
		this._tlbitms_.add("tlbSalueEditList___TITLE_",  {xtype:"tbtext", text:"PayScaleRateValue"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbSalueEditList__") != -1); } )
		this._tlbs_.add("tlbSalueEditList" , t.getRange() );
	


			this._getDc_("value").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbSalueEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("value").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbSalueEditList__load")) this._tlbitms_.get("tlbSalueEditList__load").enable();
                 if(this._tlbitms_.get("tlbSalueEditList__new_sr"))this._tlbitms_.get("tlbSalueEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbSalueEditList__new_mr"))this._tlbitms_.get("tlbSalueEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("value").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbSalueEditList__copy_mr")) this._tlbitms_.get("tlbSalueEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbSalueEditList__delete_mr")) this._tlbitms_.get("tlbSalueEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbSalueEditList__copy_mr")) this._tlbitms_.get("tlbSalueEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbSalueEditList__delete_mr")) this._tlbitms_.get("tlbSalueEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("value").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbSalueEditList__load")) this._tlbitms_.get("tlbSalueEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbSalueEditList__save_mr")) this._tlbitms_.get("tlbSalueEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbSalueEditList__rollback_record_mr"))this._tlbitms_.get("tlbSalueEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbSalueEditList__rollback_mr"))this._tlbitms_.get("tlbSalueEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("value").on("cleanRecord" , function() {
		  		  if (this._getDc_("value").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbSalueEditList__load")) this._tlbitms_.get("tlbSalueEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbSalueEditList__save_mr"))this._tlbitms_.get("tlbSalueEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbSalueEditList__rollback_record_mr"))this._tlbitms_.get("tlbSalueEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbSalueEditList__rollback_mr"))this._tlbitms_.get("tlbSalueEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbSalueEditList__load")) this._tlbitms_.get("tlbSalueEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbSalueEditList__back_mr"))this._tlbitms_.get("tlbSalueEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbSalueEditList__save_mr"))this._tlbitms_.get("tlbSalueEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbSalueEditList__rollback_record_mr"))this._tlbitms_.get("tlbSalueEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbSalueEditList__rollback_mr"))this._tlbitms_.get("tlbSalueEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("srate").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("srateEdit").id ]);								 
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
Ext.reg("net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI", net.nan21.dnet.module.hr.grade.frame.PayScaleRate_UI);   
