 
Dnet.import(["", "nan21.dnet.module.hr.ui.extjs/ds/PayrollDs", "nan21.dnet.module.hr.ui.extjs/dc/Payroll", "nan21.dnet.module.hr.ui.extjs/ds/PayrollPeriodDs", "nan21.dnet.module.hr.ui.extjs/dc/PayrollPeriod"]);

Ext.ns("net.nan21.dnet.module.hr.payroll.frame");
net.nan21.dnet.module.hr.payroll.frame.Payroll_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.hr.payroll.frame.Payroll_UI"
	
	,_defineDcs_: function () {	
		var  payroll = new net.nan21.dnet.module.hr.payroll.dc.Payroll({multiEdit:false}), period = new net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod({multiEdit:true});	 	
		
		this._dcs_.add("payroll", payroll);			
		period.setDcContext(new dnet.base.DcContext({childDc:period, parentDc:payroll, relation:{fetchMode:"auto", strict: true, fields:[ {childField:"payrollId", parentField:"id"} ]}}));payroll.addChild(period);
		this._dcs_.add("period", period);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("payrollFilter", { xtype:"net.nan21.dnet.module.hr.payroll.dc.Payroll$Filter", id:Ext.id(), _controller_:this._dcs_.get("payroll") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("payrollList", { xtype:"net.nan21.dnet.module.hr.payroll.dc.Payroll$List", id:Ext.id(), _controller_:this._dcs_.get("payroll") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("payrollEdit", { xtype:"net.nan21.dnet.module.hr.payroll.dc.Payroll$Edit", id:Ext.id(), _controller_:this._dcs_.get("payroll"),height:90 ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("payroll").isRecordValid = this._dcs_.get("payroll").isRecordValid.createInterceptor(function() { return this._getElement_("payrollEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("periodCtxEditList", { xtype:"net.nan21.dnet.module.hr.payroll.dc.PayrollPeriod$CtxEditList", frame:true, id:Ext.id(), _controller_:this._dcs_.get("period") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("payrollFilter")["region"] = "north";			
			this._elems_.get("payrollList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("payrollFilter") , this._elems_.get("payrollList") ]; 				 		
 
			this._elems_.get("payrollEdit")["region"] = "north";			
			this._elems_.get("periodCtxEditList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("payrollEdit") , this._elems_.get("periodCtxEditList") ]; 				 		
	 	this._linkToolbar_("tlbPayrollList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbPayrollEdit", "canvas2");	 	  	
	 	this._linkToolbar_("tlbPeriodCtxEditList", "periodCtxEditList");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbPayrollList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("payroll").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPayrollList-load"
		this._tlbitms_.add("tlbPayrollList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payroll")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbPayrollList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPayrollList-edit_sr"
		this._tlbitms_.add("tlbPayrollList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("payroll").doNew(); this._invokeTlbItem_("tlbPayrollList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPayrollList-new_sr"
		this._tlbitms_.add("tlbPayrollList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payroll").doCopy(); this._invokeTlbItem_("tlbPayrollList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPayrollList-copy_sr"
		this._tlbitms_.add("tlbPayrollList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payroll").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPayrollList-delete_selected_sr"
		this._tlbitms_.add("tlbPayrollList___S00_", "-") ;
		this._tlbitms_.add("tlbPayrollList___S01_", "-") ;
		this._tlbitms_.add("tlbPayrollList___TITLE_",  {xtype:"tbtext", text:"Payroll"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbPayrollList__") != -1); } )
		this._tlbs_.add("tlbPayrollList" , t.getRange() );

		this._getDc_("payroll").on("onEdit", function() {this._invokeTlbItem_("tlbPayrollList__edit_sr");} , this);

	


			this._getDc_("payroll").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbPayrollList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("payroll").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbPayrollList__load")) this._tlbitms_.get("tlbPayrollList__load").enable();
                 if(this._tlbitms_.get("tlbPayrollList__new_sr"))this._tlbitms_.get("tlbPayrollList__new_sr").enable();
                 if(this._tlbitms_.get("tlbPayrollList__new_mr"))this._tlbitms_.get("tlbPayrollList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("payroll").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbPayrollList__edit_sr")) this._tlbitms_.get("tlbPayrollList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbPayrollList__copy_sr")) this._tlbitms_.get("tlbPayrollList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbPayrollList__delete_selected_sr")) this._tlbitms_.get("tlbPayrollList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbPayrollList__edit_sr")) this._tlbitms_.get("tlbPayrollList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbPayrollList__copy_sr")) this._tlbitms_.get("tlbPayrollList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbPayrollList__delete_selected_sr")) this._tlbitms_.get("tlbPayrollList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbPayrollEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("payroll")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbPayrollEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPayrollEdit-back_sr"
		this._tlbitms_.add("tlbPayrollEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payroll").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPayrollEdit-save"
		this._tlbitms_.add("tlbPayrollEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("payroll").doNew(); this._invokeTlbItem_("tlbPayrollEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPayrollEdit-new_sr"
		this._tlbitms_.add("tlbPayrollEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("payroll").doCopy(); this._invokeTlbItem_("tlbPayrollEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPayrollEdit-copy_sr"
		this._tlbitms_.add("tlbPayrollEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("payroll").getCurrentRecord().phantom) {this._getDc_("payroll").discardChanges();this._invokeTlbItem_("tlbPayrollEdit__back_sr");} else  {this._getDc_("payroll").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPayrollEdit-rollback_sr"
		this._tlbitms_.add("tlbPayrollEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("payroll").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPayrollEdit-prev_rec_sr"
		this._tlbitms_.add("tlbPayrollEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("payroll").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPayrollEdit-next_rec_sr"
		this._tlbitms_.add("tlbPayrollEdit___S00_", "-") ;
		this._tlbitms_.add("tlbPayrollEdit___S01_", "-") ;
		this._tlbitms_.add("tlbPayrollEdit___TITLE_",  {xtype:"tbtext", text:"Payroll"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbPayrollEdit__") != -1); } )
		this._tlbs_.add("tlbPayrollEdit" , t.getRange() );
	


			this._getDc_("payroll").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbPayrollEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("payroll").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbPayrollEdit__load")) this._tlbitms_.get("tlbPayrollEdit__load").enable();
                 if(this._tlbitms_.get("tlbPayrollEdit__new_sr"))this._tlbitms_.get("tlbPayrollEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbPayrollEdit__new_mr"))this._tlbitms_.get("tlbPayrollEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("payroll").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbPayrollEdit__back_sr")) this._tlbitms_.get("tlbPayrollEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbPayrollEdit__save")) this._tlbitms_.get("tlbPayrollEdit__save").enable();
                    if(this._tlbitms_.get("tlbPayrollEdit__new_sr")) this._tlbitms_.get("tlbPayrollEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbPayrollEdit__copy_sr")) this._tlbitms_.get("tlbPayrollEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbPayrollEdit__rollback_record_sr")) this._tlbitms_.get("tlbPayrollEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbPayrollEdit__rollback_sr")) this._tlbitms_.get("tlbPayrollEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbPayrollEdit__prev_rec_sr")) this._tlbitms_.get("tlbPayrollEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbPayrollEdit__next_rec_sr")) this._tlbitms_.get("tlbPayrollEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("payroll").on("cleanRecord" , function() {
		  		  if (this._getDc_("payroll").isDirty() ) {
                    if(this._tlbitms_.get("tlbPayrollEdit__back_sr")) this._tlbitms_.get("tlbPayrollEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbPayrollEdit__save")) this._tlbitms_.get("tlbPayrollEdit__save").enable();
                    if(this._tlbitms_.get("tlbPayrollEdit__new_sr")) this._tlbitms_.get("tlbPayrollEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbPayrollEdit__copy_sr")) this._tlbitms_.get("tlbPayrollEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbPayrollEdit__rollback_record_sr")) this._tlbitms_.get("tlbPayrollEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbPayrollEdit__rollback_sr")) this._tlbitms_.get("tlbPayrollEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbPayrollEdit__prev_rec_sr")) this._tlbitms_.get("tlbPayrollEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbPayrollEdit__next_rec_sr")) this._tlbitms_.get("tlbPayrollEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbPayrollEdit__back_sr")) this._tlbitms_.get("tlbPayrollEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbPayrollEdit__save")) this._tlbitms_.get("tlbPayrollEdit__save").disable();
                  	if(this._tlbitms_.get("tlbPayrollEdit__new_sr")) this._tlbitms_.get("tlbPayrollEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbPayrollEdit__copy_sr")) this._tlbitms_.get("tlbPayrollEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbPayrollEdit__rollback_record_sr")) this._tlbitms_.get("tlbPayrollEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbPayrollEdit__rollback_sr")) this._tlbitms_.get("tlbPayrollEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbPayrollEdit__prev_rec_sr")) this._tlbitms_.get("tlbPayrollEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbPayrollEdit__next_rec_sr")) this._tlbitms_.get("tlbPayrollEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("payroll").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbPayrollEdit__copy_sr")) this._tlbitms_.get("tlbPayrollEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbPeriodCtxEditList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("period").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPeriodCtxEditList-load"
		this._tlbitms_.add("tlbPeriodCtxEditList__save_mr", new Ext.Action({_name_:"save_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save_mr__lbl"), tooltip: Dnet.translate("tlbitem", "save_mr__tlp"), iconCls: "icon-action-saveAll", scope:this , disabled: true
			, handler:function() {try {this._getDc_("period").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbPeriodCtxEditList-save_mr"
		this._tlbitms_.add("tlbPeriodCtxEditList__new_mr", new Ext.Action({_name_:"new_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_mr__lbl"), tooltip: Dnet.translate("tlbitem", "new_mr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("period").doNew(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPeriodCtxEditList-new_mr"
		this._tlbitms_.add("tlbPeriodCtxEditList__copy_mr", new Ext.Action({_name_:"copy_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_mr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_mr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("period").doCopy(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPeriodCtxEditList-copy_mr"
		this._tlbitms_.add("tlbPeriodCtxEditList__delete_mr", new Ext.Action({_name_:"delete_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_mr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_mr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("period").confirmDeleteSelection(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPeriodCtxEditList-delete_mr"
		this._tlbitms_.add("tlbPeriodCtxEditList__rollback_mr", new Ext.Action({_name_:"rollback_mr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_mr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_mr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try { this._getDc_("period").discardChanges(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbPeriodCtxEditList-rollback_mr"
		this._tlbitms_.add("tlbPeriodCtxEditList___S00_", "-") ;
		this._tlbitms_.add("tlbPeriodCtxEditList___S01_", "-") ;
		this._tlbitms_.add("tlbPeriodCtxEditList___TITLE_",  {xtype:"tbtext", text:"PayrollPeriod"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbPeriodCtxEditList__") != -1); } )
		this._tlbs_.add("tlbPeriodCtxEditList" , t.getRange() );
	


			this._getDc_("period").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbPeriodCtxEditList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("period").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbPeriodCtxEditList__load")) this._tlbitms_.get("tlbPeriodCtxEditList__load").enable();
                 if(this._tlbitms_.get("tlbPeriodCtxEditList__new_sr"))this._tlbitms_.get("tlbPeriodCtxEditList__new_sr").enable();
                 if(this._tlbitms_.get("tlbPeriodCtxEditList__new_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__new_mr").enable();
			  } , this );
			  
	

				  	
	
			this._getDc_("period").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {                         
                        if(this._tlbitms_.get("tlbPeriodCtxEditList__copy_mr")) this._tlbitms_.get("tlbPeriodCtxEditList__copy_mr").enable();
                        if(this._tlbitms_.get("tlbPeriodCtxEditList__delete_mr")) this._tlbitms_.get("tlbPeriodCtxEditList__delete_mr").enable();
					} else {                        
                       if(this._tlbitms_.get("tlbPeriodCtxEditList__copy_mr")) this._tlbitms_.get("tlbPeriodCtxEditList__copy_mr").disable();
                       if(this._tlbitms_.get("tlbPeriodCtxEditList__delete_mr")) this._tlbitms_.get("tlbPeriodCtxEditList__delete_mr").disable();
					}

			  } , this );
			this._getDc_("period").on("dirtyRecord" , function() {
					if(this._tlbitms_.get("tlbPeriodCtxEditList__load")) this._tlbitms_.get("tlbPeriodCtxEditList__load").disable();		  			 
                    if(this._tlbitms_.get("tlbPeriodCtxEditList__save_mr")) this._tlbitms_.get("tlbPeriodCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbPeriodCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbPeriodCtxEditList__rollback_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__rollback_mr").enable();
			  } , this );

			this._getDc_("period").on("cleanRecord" , function() {
		  		  if (this._getDc_("period").isDirty() ) {   
		  		  	if(this._tlbitms_.get("tlbPeriodCtxEditList__load")) this._tlbitms_.get("tlbPeriodCtxEditList__load").disable();	                
                    if(this._tlbitms_.get("tlbPeriodCtxEditList__save_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__save_mr").enable();
                    if(this._tlbitms_.get("tlbPeriodCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__rollback_record_mr").enable();
                    if(this._tlbitms_.get("tlbPeriodCtxEditList__rollback_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__rollback_mr").enable();
				  }  else {
				  	if(this._tlbitms_.get("tlbPeriodCtxEditList__load")) this._tlbitms_.get("tlbPeriodCtxEditList__load").enable();	
                  	if(this._tlbitms_.get("tlbPeriodCtxEditList__back_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__back_mr").enable();
                  	if(this._tlbitms_.get("tlbPeriodCtxEditList__save_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__save_mr").disable();
                  	if(this._tlbitms_.get("tlbPeriodCtxEditList__rollback_record_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__rollback_record_mr").disable();
                  	if(this._tlbitms_.get("tlbPeriodCtxEditList__rollback_mr"))this._tlbitms_.get("tlbPeriodCtxEditList__rollback_mr").disable();
				  }
				   } , this );
	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("payroll").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("payrollEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
		this._dcs_.get("period").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [ ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.hr.payroll.frame.Payroll_UI", net.nan21.dnet.module.hr.payroll.frame.Payroll_UI);   
