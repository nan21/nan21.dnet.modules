 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/ElementDs", "nan21.dnet.module.hr.ui.extjs/dc/Element", "nan21.dnet.module.hr.ui.extjs/ds/VariableDs", "nan21.dnet.module.hr.ui.extjs/dc/Variable","nan21.dnet.module.hr.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementTypes","nan21.dnet.module.hr.ui.extjs/ds/ElementTypeLovDs","nan21.dnet.module.hr.ui.extjs/lov/ElementTypes","nan21.dnet.module.hr.ui.extjs/ds/ElementLovDs","nan21.dnet.module.hr.ui.extjs/lov/Elements"]);

Ext.ns("net.nan21.dnet.module.hr.payroll.frame");
net.nan21.dnet.module.hr.payroll.frame.Element_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.Element_UI"
	
	,_defineDcs_: function () {	
		var  expr = new net.nan21.dnet.module.hr.payroll.dc.Element({multiEdit:false}), vars = new net.nan21.dnet.module.hr.payroll.dc.Variable({multiEdit:true});	 	
		
		this._dcs_.add("expr", expr);			
		vars.setDcContext(new dnet.base.DcContext({childDc:vars, parentDc:expr, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"elementId", parentField:"id"} ]}}));expr.addChild(vars);
		this._dcs_.add("vars", vars);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("exprFilter", { xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$Filter", id:Ext.id(), _controller_:this._dcs_.get("expr") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("exprList", { xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$List", id:Ext.id(), _controller_:this._dcs_.get("expr") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("exprEdit", { xtype:"net.nan21.dnet.module.hr.payroll.dc.Element$Edit", id:Ext.id(), _controller_:this._dcs_.get("expr"),height:120 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("expr").isRecordValid = this._dcs_.get("expr").isRecordValid.createInterceptor(function() { return this._getElement_("exprEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("varEditList", { xtype:"net.nan21.dnet.module.hr.payroll.dc.Variable$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("vars") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("exprFilter")["region"] = "north";			
			this._elems_.get("exprList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("exprFilter") , this._elems_.get("exprList") ]; 				 		
 
			this._elems_.get("exprEdit")["region"] = "north";			
			this._elems_.get("varEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("exprEdit") , this._elems_.get("varEditList") ]; 				 		
	 	this._linkToolbar_("tlbExprList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbExprEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbVarEditList", "varEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbExprList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("expr").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbExprList-load"
		this._tlbitms_.add("tlbExprList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("expr")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbExprList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbExprList-edit_sr"
		this._tlbitms_.add("tlbExprList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("expr").doNew(); this._invokeTlbItem_("tlbExprList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbExprList-new_sr"
		this._tlbitms_.add("tlbExprList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("expr").doCopy(); this._invokeTlbItem_("tlbExprList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbExprList-copy_sr"
		this._tlbitms_.add("tlbExprList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("expr").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbExprList-delete_selected_sr"
		this._tlbitms_.add("tlbExprList___S00_", "-") ;
		this._tlbitms_.add("tlbExprList___S01_", "-") ;
		this._tlbitms_.add("tlbExprList___TITLE_",  {xtype:"tbtext", text:"Element"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbExprList__") != -1); } )
		this._tlbs_.add("tlbExprList" , t.getRange() );

		this._getDc_("expr").on("onEdit", function() {this._invokeTlbItem_("tlbExprList__edit_sr");} , this);

	


			this._getDc_("expr").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbExprList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("expr").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbExprList__load")) this._tlbitms_.get("tlbExprList__load").enable();
                 if(this._tlbitms_.get("tlbExprList__new_sr"))this._tlbitms_.get("tlbExprList__new_sr").enable();
                 if(this._tlbitms_.get("tlbExprList__new_mr"))this._tlbitms_.get("tlbExprList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("expr").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbExprList__edit_sr")) this._tlbitms_.get("tlbExprList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbExprList__copy_sr")) this._tlbitms_.get("tlbExprList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbExprList__delete_selected_sr")) this._tlbitms_.get("tlbExprList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbExprList__edit_sr")) this._tlbitms_.get("tlbExprList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbExprList__copy_sr")) this._tlbitms_.get("tlbExprList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbExprList__delete_selected_sr")) this._tlbitms_.get("tlbExprList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbExprEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("expr")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbExprEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbExprEdit-back_sr"
		this._tlbitms_.add("tlbExprEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("expr").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbExprEdit-save"
		this._tlbitms_.add("tlbExprEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("expr").doNew(); this._invokeTlbItem_("tlbExprEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbExprEdit-new_sr"
		this._tlbitms_.add("tlbExprEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("expr").doCopy(); this._invokeTlbItem_("tlbExprEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbExprEdit-copy_sr"
		this._tlbitms_.add("tlbExprEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("expr").getCurrentRecord().phantom) {this._getDc_("expr").discardChanges();this._invokeTlbItem_("tlbExprEdit__back_sr");} else  {this._getDc_("expr").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbExprEdit-rollback_sr"
		this._tlbitms_.add("tlbExprEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("expr").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbExprEdit-prev_rec_sr"
		this._tlbitms_.add("tlbExprEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("expr").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbExprEdit-next_rec_sr"
		this._tlbitms_.add("tlbExprEdit___S00_", "-") ;
		this._tlbitms_.add("tlbExprEdit___S01_", "-") ;
		this._tlbitms_.add("tlbExprEdit___TITLE_",  {xtype:"tbtext", text:"Element"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbExprEdit__") != -1); } )
		this._tlbs_.add("tlbExprEdit" , t.getRange() );
	


			this._getDc_("expr").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbExprEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("expr").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbExprEdit__load")) this._tlbitms_.get("tlbExprEdit__load").enable();
                 if(this._tlbitms_.get("tlbExprEdit__new_sr"))this._tlbitms_.get("tlbExprEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbExprEdit__new_mr"))this._tlbitms_.get("tlbExprEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("expr").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbExprEdit__back_sr")) this._tlbitms_.get("tlbExprEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbExprEdit__save")) this._tlbitms_.get("tlbExprEdit__save").enable();
                    if(this._tlbitms_.get("tlbExprEdit__new_sr")) this._tlbitms_.get("tlbExprEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbExprEdit__copy_sr")) this._tlbitms_.get("tlbExprEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbExprEdit__rollback_record_sr")) this._tlbitms_.get("tlbExprEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbExprEdit__rollback_sr")) this._tlbitms_.get("tlbExprEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbExprEdit__prev_rec_sr")) this._tlbitms_.get("tlbExprEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbExprEdit__next_rec_sr")) this._tlbitms_.get("tlbExprEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("expr").on("cleanRecord" , function() {
		  		  if (this._getDc_("expr").isDirty() ) {
                    if(this._tlbitms_.get("tlbExprEdit__back_sr")) this._tlbitms_.get("tlbExprEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbExprEdit__save")) this._tlbitms_.get("tlbExprEdit__save").enable();
                    if(this._tlbitms_.get("tlbExprEdit__new_sr")) this._tlbitms_.get("tlbExprEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbExprEdit__copy_sr")) this._tlbitms_.get("tlbExprEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbExprEdit__rollback_record_sr")) this._tlbitms_.get("tlbExprEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbExprEdit__rollback_sr")) this._tlbitms_.get("tlbExprEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbExprEdit__prev_rec_sr")) this._tlbitms_.get("tlbExprEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbExprEdit__next_rec_sr")) this._tlbitms_.get("tlbExprEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbExprEdit__back_sr")) this._tlbitms_.get("tlbExprEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbExprEdit__save")) this._tlbitms_.get("tlbExprEdit__save").disable();
                  	if(this._tlbitms_.get("tlbExprEdit__new_sr")) this._tlbitms_.get("tlbExprEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbExprEdit__copy_sr")) this._tlbitms_.get("tlbExprEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbExprEdit__rollback_record_sr")) this._tlbitms_.get("tlbExprEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbExprEdit__rollback_sr")) this._tlbitms_.get("tlbExprEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbExprEdit__prev_rec_sr")) this._tlbitms_.get("tlbExprEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbExprEdit__next_rec_sr")) this._tlbitms_.get("tlbExprEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("expr").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbExprEdit__copy_sr")) this._tlbitms_.get("tlbExprEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbVarEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("vars").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbVarEditList-load"
		this._tlbitms_.add("tlbVarEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("vars").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbVarEditList-save_mr"
		this._tlbitms_.add("tlbVarEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("vars").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbVarEditList-new_mr"
		this._tlbitms_.add("tlbVarEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("vars").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbVarEditList-copy_mr"
		this._tlbitms_.add("tlbVarEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("vars").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbVarEditList-delete_mr"
		this._tlbitms_.add("tlbVarEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("vars").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbVarEditList-rollback_mr"
		this._tlbitms_.add("tlbVarEditList___S00_", "-") ;
		this._tlbitms_.add("tlbVarEditList___S01_", "-") ;
		this._tlbitms_.add("tlbVarEditList___TITLE_",  {xtype:"tbtext", text:"Variable"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbVarEditList__") != -1); } )
		this._tlbs_.add("tlbVarEditList" , t.getRange() );
	


			this._getDc_("vars").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbVarEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("vars").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbVarEditList__load")) this._tlbitms_.get("tlbVarEditList__load").enable();
                 if(this._tlbitms_.get("tlbVarEditList__new_sr"))this._tlbitms_.get("tlbVarEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbVarEditList__new_mr"))this._tlbitms_.get("tlbVarEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("vars").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbVarEditList__copy_mr")) this._tlbitms_.get("tlbVarEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbVarEditList__delete_mr")) this._tlbitms_.get("tlbVarEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbVarEditList__copy_mr")) this._tlbitms_.get("tlbVarEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbVarEditList__delete_mr")) this._tlbitms_.get("tlbVarEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("vars").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbVarEditList__load")) this._tlbitms_.get("tlbVarEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbVarEditList__save_mr")) this._tlbitms_.get("tlbVarEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbVarEditList__rollback_record_mr"))this._tlbitms_.get("tlbVarEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbVarEditList__rollback_mr"))this._tlbitms_.get("tlbVarEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("vars").on("cleanRecord" , function() {
		  		  if (this._getDc_("vars").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbVarEditList__load")) this._tlbitms_.get("tlbVarEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbVarEditList__save_mr"))this._tlbitms_.get("tlbVarEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbVarEditList__rollback_record_mr"))this._tlbitms_.get("tlbVarEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbVarEditList__rollback_mr"))this._tlbitms_.get("tlbVarEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbVarEditList__load")) this._tlbitms_.get("tlbVarEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbVarEditList__back_mr"))this._tlbitms_.get("tlbVarEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbVarEditList__save_mr"))this._tlbitms_.get("tlbVarEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbVarEditList__rollback_record_mr"))this._tlbitms_.get("tlbVarEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbVarEditList__rollback_mr"))this._tlbitms_.get("tlbVarEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("expr").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("exprEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("vars").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.payroll.frame.Element_UI", net.nan21.dnet.module.hr.payroll.frame.Element_UI);   
