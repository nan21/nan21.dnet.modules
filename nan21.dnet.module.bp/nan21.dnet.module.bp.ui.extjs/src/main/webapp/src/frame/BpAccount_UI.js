 
Dnet.import(["", "nan21.dnet.module.bp.ui.extjs/ds/BpAccountDs", "nan21.dnet.module.bp.ui.extjs/dc/BpAccount","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.ad.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.ad.ui.extjs/lov/Organizations","nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomerGroup","nan21.dnet.module.bp.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bp.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bp.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bp.ui.extjs/ds/VendorGroupLovDs","nan21.dnet.module.bp.ui.extjs/lov/VendorGroup","nan21.dnet.module.bp.ui.extjs/ds/PaymentMethodLovDs","nan21.dnet.module.bp.ui.extjs/lov/PaymentMethod","nan21.dnet.module.bp.ui.extjs/ds/PaymentTermLovDs","nan21.dnet.module.bp.ui.extjs/lov/PaymentTerm","nan21.dnet.module.bp.ui.extjs/ds/BusinessPartnerLovDs","nan21.dnet.module.bp.ui.extjs/lov/BusinessPartners","nan21.dnet.module.ad.ui.extjs/ds/OrganizationLovDs","nan21.dnet.module.ad.ui.extjs/lov/Organizations","nan21.dnet.module.bp.ui.extjs/ds/CustomerGroupLovDs","nan21.dnet.module.bp.ui.extjs/lov/CustomerGroup","nan21.dnet.module.bp.ui.extjs/ds/VendorGroupLovDs","nan21.dnet.module.bp.ui.extjs/lov/VendorGroup"]);

Ext.ns("net.nan21.dnet.module.bp.md.frame");
net.nan21.dnet.module.bp.md.frame.BpAccount_UI = Ext.extend( dnet.base.AbstractUi, {  
	 _name_ : "net.nan21.dnet.module.bp.md.frame.BpAccount_UI"
	
	,_defineDcs_: function () {	
		var  m = new net.nan21.dnet.module.bp.md.dc.BpAccount({multiEdit:false});	 	
		
		this._dcs_.add("m", m);			
	}
	,_defineDcRelations_: function () {
	} 

	

	,_defineElements_: function () {
		this._elems_.add("mFilter", { xtype:"net.nan21.dnet.module.bp.md.dc.BpAccount$Filter", id:Ext.id(), _controller_:this._dcs_.get("m") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("mList", { xtype:"net.nan21.dnet.module.bp.md.dc.BpAccount$List", id:Ext.id(), _controller_:this._dcs_.get("m") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		this._elems_.add("mEdit", { xtype:"net.nan21.dnet.module.bp.md.dc.BpAccount$Edit", id:Ext.id(), _controller_:this._dcs_.get("m") ,listeners:{ activate:{scope:this,fn:function(){this.doLayout(false,true);} } } });	
		  this._dcs_.get("m").isRecordValid = this._dcs_.get("m").isRecordValid.createInterceptor(function() { return this._getElement_("mEdit")._isValid_(); }, this);		 
		  
		this._elems_.add("main", { layout:"card", activeItem:0, id:Ext.id(),listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true);  } }} });						
		this._elems_.add("canvas1", { layout:"border", id:Ext.id(), defaults:{split:true},title:"List",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });
		this._elems_.add("canvas2", { layout:"border", id:Ext.id(), defaults:{split:true},title:"Editor",header:false,listeners:{ activate:{scope:this,fn:function(p){p.doLayout(false,true); this.fireEvent('canvaschange', p);     } }} });					
			
					 	
	}

	,_linkElements_: function () {	
 
	
	 	this._elems_.get("main")["items"] = [ this._elems_.get("canvas1") , this._elems_.get("canvas2") ]; 				 		
 
			this._elems_.get("mFilter")["region"] = "north";			
			this._elems_.get("mList")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas1")["items"] = [ this._elems_.get("mFilter") , this._elems_.get("mList") ]; 				 		
 
			this._elems_.get("mEdit")["region"] = "center";			
		   
	
	 	this._elems_.get("canvas2")["items"] = [ this._elems_.get("mEdit") ]; 				 		
	 	this._linkToolbar_("tlbMList", "canvas1");	 	  	
	 	this._linkToolbar_("tlbMEdit", "canvas2");	 	  	
	}

		
	,_defineToolbars_: function () {
		var t;
		
  
		this._tlbitms_.add("tlbMList__load", new Ext.Action({_name_:"load",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "load__lbl"), tooltip: Dnet.translate("tlbitem", "load__tlp"), iconCls: "icon-action-fetch", scope:this , disabled: false
			, handler:function() {try {this._getDc_("m").doQuery(); } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMList-load"
		this._tlbitms_.add("tlbMList__edit_sr", new Ext.Action({_name_:"edit_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "edit_sr__lbl"), tooltip: Dnet.translate("tlbitem", "edit_sr__tlp"), iconCls: "icon-action-edit", scope:this , disabled: true
			, handler:function() {try {this._getDc_("m")._checkCanDoEdit_();var cfg = this._configVars_.get("tlbMList__edit_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else { this._getElement_("main").getLayout().setActiveItem(1);} } catch(e) {dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMList-edit_sr"
		this._tlbitms_.add("tlbMList__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("m").doNew(); this._invokeTlbItem_("tlbMList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMList-new_sr"
		this._tlbitms_.add("tlbMList__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("m").doCopy(); this._invokeTlbItem_("tlbMList__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMList-copy_sr"
		this._tlbitms_.add("tlbMList__delete_selected_sr", new Ext.Action({_name_:"delete_selected_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "delete_selected_sr__lbl"), tooltip: Dnet.translate("tlbitem", "delete_selected_sr__tlp"), iconCls: "icon-action-delete", scope:this , disabled: true
			, handler:function() {try {this._getDc_("m").confirmDeleteSelection(); } catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMList-delete_selected_sr"
		this._tlbitms_.add("tlbMList___S00_", "-") ;
		this._tlbitms_.add("tlbMList___S01_", "-") ;
		this._tlbitms_.add("tlbMList___TITLE_",  {xtype:"tbtext", text:"BpAccount"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbMList__") != -1); } )
		this._tlbs_.add("tlbMList" , t.getRange() );

		this._getDc_("m").on("onEdit", function() {this._invokeTlbItem_("tlbMList__edit_sr");} , this);

	


			this._getDc_("m").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbMList__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("m").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbMList__load")) this._tlbitms_.get("tlbMList__load").enable();
                 if(this._tlbitms_.get("tlbMList__new_sr"))this._tlbitms_.get("tlbMList__new_sr").enable();
                 if(this._tlbitms_.get("tlbMList__new_mr"))this._tlbitms_.get("tlbMList__new_mr").enable();
			  } , this );
			  
	


			this._getDc_("m").on("afterSelectedRecordsChanged" , function(dc) {
					if (dc.selectedRecords.length > 0) {
                        if(this._tlbitms_.get("tlbMList__edit_sr")) this._tlbitms_.get("tlbMList__edit_sr").enable();
                        if(this._tlbitms_.get("tlbMList__copy_sr")) this._tlbitms_.get("tlbMList__copy_sr").enable();
                        if(this._tlbitms_.get("tlbMList__delete_selected_sr")) this._tlbitms_.get("tlbMList__delete_selected_sr").enable();
					} else {
                       if(this._tlbitms_.get("tlbMList__edit_sr")) this._tlbitms_.get("tlbMList__edit_sr").disable();
                       if(this._tlbitms_.get("tlbMList__copy_sr")) this._tlbitms_.get("tlbMList__copy_sr").disable();
                       if(this._tlbitms_.get("tlbMList__delete_selected_sr")) this._tlbitms_.get("tlbMList__delete_selected_sr").disable();
					}

			  } , this );			  
				  	
	
	
		var t;
		
  
		this._tlbitms_.add("tlbMEdit__back_sr", new Ext.Action({_name_:"back_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "back_sr__lbl"), tooltip: Dnet.translate("tlbitem", "back_sr__tlp"), iconCls: "icon-action-back", scope:this , disabled: false
			, handler:function() {try { this._getDc_("m")._checkCanChangeCurrentRecord_();var cfg = this._configVars_.get("tlbMEdit__back_sr"); if (cfg) {this._showStackedViewElement_(cfg.container,cfg.item);}else {this._getElement_("main").getLayout().setActiveItem(0);} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMEdit-back_sr"
		this._tlbitms_.add("tlbMEdit__save", new Ext.Action({_name_:"save",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "save__lbl"), tooltip: Dnet.translate("tlbitem", "save__tlp"), iconCls: "icon-action-save", scope:this , disabled: true
			, handler:function() {try {this._getDc_("m").doSave(); } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMEdit-save"
		this._tlbitms_.add("tlbMEdit__new_sr", new Ext.Action({_name_:"new_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "new_sr__lbl"), tooltip: Dnet.translate("tlbitem", "new_sr__tlp"), iconCls: "icon-action-new", scope:this , disabled: false
			, handler:function() {try {this._getDc_("m").doNew(); this._invokeTlbItem_("tlbMEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMEdit-new_sr"
		this._tlbitms_.add("tlbMEdit__copy_sr", new Ext.Action({_name_:"copy_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "copy_sr__lbl"), tooltip: Dnet.translate("tlbitem", "copy_sr__tlp"), iconCls: "icon-action-copy", scope:this , disabled: true
			, handler:function() {try {this._getDc_("m").doCopy(); this._invokeTlbItem_("tlbMEdit__edit_sr");} catch(e) {  dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMEdit-copy_sr"
		this._tlbitms_.add("tlbMEdit__rollback_sr", new Ext.Action({_name_:"rollback_sr",
			id:Ext.id()  ,text:Dnet.translate("tlbitem", "rollback_sr__lbl"), tooltip: Dnet.translate("tlbitem", "rollback_sr__tlp"), iconCls: "icon-action-rollback", scope:this , disabled: true
			, handler:function() {try {if(this._getDc_("m").getCurrentRecord().phantom) {this._getDc_("m").discardChanges();this._invokeTlbItem_("tlbMEdit__back_sr");} else  {this._getDc_("m").discardChanges();} } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMEdit-rollback_sr"
		this._tlbitms_.add("tlbMEdit__prev_rec_sr", new Ext.Action({_name_:"prev_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "prev_rec_sr__tlp"), iconCls: "icon-action-previous", scope:this , disabled: false
			, handler:function() {try { this._getDc_("m").setPreviousAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e);}} }) ); //, itemId: "menuitem-tlbMEdit-prev_rec_sr"
		this._tlbitms_.add("tlbMEdit__next_rec_sr", new Ext.Action({_name_:"next_rec_sr",
			id:Ext.id()  , tooltip: Dnet.translate("tlbitem", "next_rec_sr__tlp"), iconCls: "icon-action-next", scope:this , disabled: false
			, handler:function() {try { this._getDc_("m").setNextAsCurrent();  } catch(e) { dnet.base.DcExceptions.showMessage(e); }} }) ); //, itemId: "menuitem-tlbMEdit-next_rec_sr"
		this._tlbitms_.add("tlbMEdit___S00_", "-") ;
		this._tlbitms_.add("tlbMEdit___S01_", "-") ;
		this._tlbitms_.add("tlbMEdit___TITLE_",  {xtype:"tbtext", text:"BpAccount"} );
        
		t=this._tlbitms_.filterBy( function(o,k) {return (k.indexOf("tlbMEdit__") != -1); } )
		this._tlbs_.add("tlbMEdit" , t.getRange() );
	


			this._getDc_("m").on("inContextOfNewRecord" , function() {
				 var t = this._tlbitms_.filterBy(  function(o,k) {return (k.indexOf("tlbMEdit__") != -1); }  );
				 t.eachKey( function(k) { try {this._tlbitms_.get(k).disable();} catch(e) {} } ,this);
			  } , this );

			this._getDc_("m").on("inContextOfEditRecord" , function() {
                 if(this._tlbitms_.get("tlbMEdit__load")) this._tlbitms_.get("tlbMEdit__load").enable();
                 if(this._tlbitms_.get("tlbMEdit__new_sr"))this._tlbitms_.get("tlbMEdit__new_sr").enable();
                 if(this._tlbitms_.get("tlbMEdit__new_mr"))this._tlbitms_.get("tlbMEdit__new_mr").enable();
			  } , this );
			  

			this._getDc_("m").on("dirtyRecord" , function() {
		  			if(this._tlbitms_.get("tlbMEdit__back_sr")) this._tlbitms_.get("tlbMEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbMEdit__save")) this._tlbitms_.get("tlbMEdit__save").enable();
                    if(this._tlbitms_.get("tlbMEdit__new_sr")) this._tlbitms_.get("tlbMEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbMEdit__copy_sr")) this._tlbitms_.get("tlbMEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbMEdit__rollback_record_sr")) this._tlbitms_.get("tlbMEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbMEdit__rollback_sr")) this._tlbitms_.get("tlbMEdit__rollback_sr").enable();

                    if(this._tlbitms_.get("tlbMEdit__prev_rec_sr")) this._tlbitms_.get("tlbMEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbMEdit__next_rec_sr")) this._tlbitms_.get("tlbMEdit__next_rec_sr").disable();
			  } , this );

			this._getDc_("m").on("cleanRecord" , function() {
		  		  if (this._getDc_("m").isDirty() ) {
                    if(this._tlbitms_.get("tlbMEdit__back_sr")) this._tlbitms_.get("tlbMEdit__back_sr").disable();
                    if(this._tlbitms_.get("tlbMEdit__save")) this._tlbitms_.get("tlbMEdit__save").enable();
                    if(this._tlbitms_.get("tlbMEdit__new_sr")) this._tlbitms_.get("tlbMEdit__new_sr").disable();
                    if(this._tlbitms_.get("tlbMEdit__copy_sr")) this._tlbitms_.get("tlbMEdit__copy_sr").disable();
                    if(this._tlbitms_.get("tlbMEdit__rollback_record_sr")) this._tlbitms_.get("tlbMEdit__rollback_record_sr").enable();
                    if(this._tlbitms_.get("tlbMEdit__rollback_sr")) this._tlbitms_.get("tlbMEdit__rollback_sr").enable();
                    if(this._tlbitms_.get("tlbMEdit__prev_rec_sr")) this._tlbitms_.get("tlbMEdit__prev_rec_sr").disable();
                    if(this._tlbitms_.get("tlbMEdit__next_rec_sr")) this._tlbitms_.get("tlbMEdit__next_rec_sr").disable();
				  }  else {
                  	if(this._tlbitms_.get("tlbMEdit__back_sr")) this._tlbitms_.get("tlbMEdit__back_sr").enable();
                  	if(this._tlbitms_.get("tlbMEdit__save")) this._tlbitms_.get("tlbMEdit__save").disable();
                  	if(this._tlbitms_.get("tlbMEdit__new_sr")) this._tlbitms_.get("tlbMEdit__new_sr").enable();
                  	if(this._tlbitms_.get("tlbMEdit__copy_sr")) this._tlbitms_.get("tlbMEdit__copy_sr").enable();
                  	if(this._tlbitms_.get("tlbMEdit__rollback_record_sr")) this._tlbitms_.get("tlbMEdit__rollback_record_sr").disable();
                  	if(this._tlbitms_.get("tlbMEdit__rollback_sr")) this._tlbitms_.get("tlbMEdit__rollback_sr").disable();
                  	if(this._tlbitms_.get("tlbMEdit__prev_rec_sr")) this._tlbitms_.get("tlbMEdit__prev_rec_sr").enable();
                    if(this._tlbitms_.get("tlbMEdit__next_rec_sr")) this._tlbitms_.get("tlbMEdit__next_rec_sr").enable();
				  }
				   } , this );
			this._getDc_("m").on("afterCurrentRecordChange" , function() {
                  	if(this._tlbitms_.get("tlbMEdit__copy_sr")) this._tlbitms_.get("tlbMEdit__copy_sr").enable();
				   } , this );	   
	

				  	
	
	
	}

	
	,_defineBindings_: function () {
		this._dcs_.get("m").on('afterCurrentRecordChange', function(evnt) { var newRecord = evnt.newRecord; var oldRecord = evnt.oldRecord; var newIdx = evnt.newIdx;
			if(newRecord) {								 
				Ext.BindMgr.unbind(oldRecord);
				Ext.BindMgr.bind(newRecord, [this._elems_.get("mEdit").id ]);								 
			} else {								 
				Ext.BindMgr.unbind(oldRecord);								 
			} }, this );	
			
	}
	 
});
Ext.reg("net.nan21.dnet.module.bp.md.frame.BpAccount_UI", net.nan21.dnet.module.bp.md.frame.BpAccount_UI);   
